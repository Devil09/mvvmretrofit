package com.example.mvvmretrofit.customnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmretrofit.R

class CustomNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_notification)
    }

    /*fun showNotification(v: View?) {
        val collapsedView = RemoteViews(
            packageName,
            R.layout.notification_collapsed
        )
        val expandedView = RemoteViews(
            packageName,
            R.layout.notification_expanded
        )
        val clickIntent = Intent(this, NotificationReceiver::class.java)
        val clickPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            this,
            0, clickIntent, 0
        )
        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!")
        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.lotti2)
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)
        val notification: Notification = Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android)
            .setCustomContentView(collapsedView)
            .setCustomBigContentView(expandedView) //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
            .build()
        notificationManager.notify(1, notification)
    }*/
}