package com.collegesInNepal.collegesInNepal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import sap.collegesInNepal.R;

/**
 * Created by h on 8/26/16.
 */
public class CosmosFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    String title, body, photo;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        /*try {
            JSONObject notification = new JSONObject(remoteMessage.getNotification().toString());
            title = notification.optString("title");
            body = notification.optString("body");
            photo = notification.optString("photo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getIcon());

        //Calling method to generate notification
        sendNotification(remoteMessage.getNotification().getBody());
       /* title = remoteMessage.getNotification().getTitle();
    body = remoteMessage.getNotification().getBody();
     photo = remoteMessage.getNotification().getBody();
        Log.e("Parameters", title + body + photo);*/

    }

    public void sendNotification(String messageBody) {

        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title", title);
        intent.putExtra("body",body);
        intent.putExtra("photo",photo);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Push Notification")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());

    }


}
