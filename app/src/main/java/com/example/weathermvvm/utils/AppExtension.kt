package com.example.weathermvvm.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.weathermvvm.ConstantApp
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getDate(timestamp: Long, GMT: Any = 0, format: String = ConstantApp.dateFormat): String {
    val mFormat = format

    val dateformat: SimpleDateFormat = when {
        mFormat.length == 1 -> SimpleDateFormat(
            "dd" + format + "MM" + format + "yyyy"
        )
        else -> SimpleDateFormat(mFormat)
    }

    dateformat.timeZone = TimeZone.getTimeZone("GMT+$GMT")

    val dateRedeemDate = Date(timestamp)

    val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+$GMT"))
    calendar.time = dateRedeemDate
    val year = calendar.get(Calendar.YEAR)
    calendar.set(
        year,
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        calendar.get(Calendar.SECOND)
    )
    return dateformat.format(calendar.time.time)
}

@SuppressLint("MissingPermission")
fun Context?.isConnected(): Boolean {
    this?.let {
        (it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo?.let {
            return it.isConnected
        }
    }
    return false
}

object CustomBinding {
    @SuppressLint("SetTextI18n")
    @BindingAdapter("date", "text", requireAll = false)
    @JvmStatic
    fun handleDate(view: TextView, date: Long?, text: String?) {
        var str = ""

        if (text != null)
            str = text

        date?.let {
            if (it > 0)
                str += getDate(it * 1000, 0, ConstantApp.dateFormat)
            else
                str = ""
        }

        view.text = str
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun handleImageUrlIcon(view: ImageView, imageUrl: String? = "") {
        imageUrl.let {
            Picasso.get().load(ConstantApp.imageURL(it)).into(view)
        }
    }

    @BindingAdapter("selected")
    @JvmStatic
    fun handlerSelected(view: TextView, selected: Boolean? = false) {
        selected.let {
            view.isSelected = it!!
        }
    }
}