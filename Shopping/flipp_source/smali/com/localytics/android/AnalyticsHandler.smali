.class Lcom/localytics/android/AnalyticsHandler;
.super Lcom/localytics/android/BaseHandler;
.source "SourceFile"


# static fields
.field private static final MESSAGE_CLOSE:I = 0x66

.field private static final MESSAGE_DISABLE_PUSH:I = 0x70

.field private static final MESSAGE_HANDLE_PUSH_REGISTRATION:I = 0x6e

.field private static final MESSAGE_OPEN:I = 0x65

.field private static final MESSAGE_OPT_OUT:I = 0x6c

.field private static final MESSAGE_REGISTER_PUSH:I = 0x6d

.field private static final MESSAGE_SET_CUSTOM_DIMENSION:I = 0x6b

.field private static final MESSAGE_SET_IDENTIFIER:I = 0x69

.field private static final MESSAGE_SET_LOCATION:I = 0x6a

.field private static final MESSAGE_SET_PUSH_REGID:I = 0x71

.field private static final MESSAGE_SET_REFERRERID:I = 0x72

.field private static final MESSAGE_TAG_EVENT:I = 0x67

.field private static final MESSAGE_TAG_SCREEN:I = 0x68

.field private static final PARAM_LOCALYTICS_REFERRER_TEST_MODE:Ljava/lang/String; = "localytics_test_mode"

.field private static final PROJECTION_SET_CUSTOM_DIMENSION:[Ljava/lang/String;

.field private static final PROJECTION_SET_IDENTIFIER:[Ljava/lang/String;

.field private static final SELECTION_SET_CUSTOM_DIMENSION:Ljava/lang/String;

.field private static final SELECTION_SET_IDENTIFIER:Ljava/lang/String;

.field private static sLastLocation:Landroid/location/Location;


# instance fields
.field private mAppWasUpgraded:Z

.field mFirstSessionEver:Z

.field mReferrerTestModeEnabled:Z

.field mSentReferrerTestMode:Z

.field private final screenFlow:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 132
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "custom_dimension_value"

    aput-object v1, v0, v3

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->PROJECTION_SET_CUSTOM_DIMENSION:[Ljava/lang/String;

    .line 137
    const-string v0, "%s = ?"

    new-array v1, v4, [Ljava/lang/Object;

    const-string v2, "custom_dimension_key"

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_CUSTOM_DIMENSION:Ljava/lang/String;

    .line 142
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "key"

    aput-object v1, v0, v3

    const-string v1, "value"

    aput-object v1, v0, v4

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->PROJECTION_SET_IDENTIFIER:[Ljava/lang/String;

    .line 147
    const-string v0, "%s = ?"

    new-array v1, v4, [Ljava/lang/Object;

    const-string v2, "key"

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_IDENTIFIER:Ljava/lang/String;

    .line 153
    const/4 v0, 0x0

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->sLastLocation:Landroid/location/Location;

    return-void
.end method

.method constructor <init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 180
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/BaseHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V

    .line 155
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    .line 156
    iput-boolean v1, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    .line 157
    iput-boolean v1, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    .line 158
    iput-boolean v1, p0, Lcom/localytics/android/AnalyticsHandler;->mReferrerTestModeEnabled:Z

    .line 159
    iput-boolean v1, p0, Lcom/localytics/android/AnalyticsHandler;->mSentReferrerTestMode:Z

    .line 181
    const-string v0, "Analytics"

    iput-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->siloName:Ljava/lang/String;

    .line 182
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$AnalyticsListenersSet;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/localytics/android/AnalyticsHandler$AnalyticsListenersSet;-><init>(Lcom/localytics/android/AnalyticsHandler;Lcom/localytics/android/AnalyticsHandler$1;)V

    iput-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    .line 183
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 184
    return-void
.end method

.method private _addLocationIDsAndCustomDimensions(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    const/4 v6, 0x0

    .line 1135
    :try_start_0
    sget-object v0, Lcom/localytics/android/AnalyticsHandler;->sLastLocation:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 1137
    sget-object v0, Lcom/localytics/android/AnalyticsHandler;->sLastLocation:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    .line 1138
    sget-object v2, Lcom/localytics/android/AnalyticsHandler;->sLastLocation:Landroid/location/Location;

    invoke-virtual {v2}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    .line 1139
    cmpl-double v4, v0, v8

    if-eqz v4, :cond_0

    cmpl-double v4, v2, v8

    if-eqz v4, :cond_0

    .line 1141
    const-string v4, "lat"

    invoke-virtual {p1, v4, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1142
    const-string v0, "lng"

    invoke-virtual {p1, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 1146
    :cond_0
    const-string v0, "cid"

    invoke-virtual {p1, v0, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1147
    const-string v0, "utp"

    invoke-virtual {p1, v0, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1149
    invoke-virtual {p2}, Lorg/json/JSONObject;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 1151
    const-string v0, "ids"

    invoke-virtual {p1, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1160
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "custom_dimensions"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v1

    .line 1162
    :goto_0
    :try_start_2
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1164
    const-string v0, "custom_dimension_key"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1165
    const-string v2, "custom_dimension_value"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1166
    const-string v3, "custom_dimension_"

    const-string v4, "c"

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1167
    invoke-virtual {p1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 1172
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v1, :cond_2

    .line 1174
    :try_start_3
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1175
    :cond_2
    throw v0

    .line 1182
    :catch_0
    move-exception v0

    :cond_3
    :goto_2
    return-void

    .line 1172
    :cond_4
    if-eqz v1, :cond_3

    .line 1174
    invoke-interface {v1}, Landroid/database/Cursor;->close()V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_2

    .line 1172
    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_1
.end method

.method private _close()V
    .locals 1

    .prologue
    .line 1374
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isSessionOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1376
    const-string v0, "Session was not open, so close is not possible."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 1383
    :goto_0
    return-void

    .line 1380
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/AnalyticsListener;

    invoke-interface {v0}, Lcom/localytics/android/AnalyticsListener;->localyticsSessionWillClose()V

    .line 1382
    const-string v0, "close"

    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_tagEvent(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private _dequeQueuedCloseSessionTag(Z)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v6, 0x0

    .line 1282
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 1284
    if-eqz p1, :cond_1

    .line 1289
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "queued_close_session_blob"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "queued_close_session_blob_upload_format"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1290
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1292
    const-string v0, "queued_close_session_blob"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1293
    const-string v2, "queued_close_session_blob_upload_format"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    .line 1295
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1297
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 1298
    const-string v3, "blob"

    invoke-virtual {v7, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1299
    const-string v0, "upload_format"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1300
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "events"

    invoke-virtual {v0, v2, v7}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1301
    invoke-virtual {v7}, Landroid/content/ContentValues;->clear()V

    .line 1302
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    .line 1303
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1309
    :cond_0
    if-eqz v1, :cond_1

    .line 1311
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1317
    :cond_1
    const-string v0, "queued_close_session_blob"

    invoke-virtual {v7, v0}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 1318
    const-string v0, "queued_close_session_blob_upload_format"

    invoke-virtual {v7, v0}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 1319
    const-string v0, "last_session_close_time"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v7, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1320
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    invoke-virtual {v0, v1, v7, v6, v6}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1321
    return-void

    .line 1309
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_0
    if-eqz v1, :cond_2

    .line 1311
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1312
    :cond_2
    throw v0

    .line 1309
    :catchall_1
    move-exception v0

    goto :goto_0
.end method

.method private _getCustomDimension(I)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 737
    if-ltz p1, :cond_0

    const/16 v0, 0xa

    if-le p1, v0, :cond_2

    :cond_0
    move-object v0, v6

    .line 763
    :cond_1
    :goto_0
    return-object v0

    .line 743
    :cond_2
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->getCustomDimensionAttributeKey(I)Ljava/lang/String;

    move-result-object v5

    .line 747
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "custom_dimensions"

    sget-object v2, Lcom/localytics/android/AnalyticsHandler;->PROJECTION_SET_CUSTOM_DIMENSION:[Ljava/lang/String;

    sget-object v3, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_CUSTOM_DIMENSION:Ljava/lang/String;

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v5, v4, v7

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 749
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 751
    const-string v0, "custom_dimension_value"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 756
    :goto_1
    if-eqz v1, :cond_1

    .line 758
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 756
    :catchall_0
    move-exception v0

    :goto_2
    if-eqz v6, :cond_3

    .line 758
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 759
    :cond_3
    throw v0

    .line 756
    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_2

    :cond_4
    move-object v0, v6

    goto :goto_1
.end method

.method private _getIdentifiers()Lorg/json/JSONObject;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 1485
    .line 1486
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 1489
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "identifiers"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 1491
    :goto_0
    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1493
    const-string v1, "key"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "value"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 1501
    :catch_0
    move-exception v1

    :goto_1
    if-eqz v0, :cond_0

    .line 1503
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_0
    move-object v0, v6

    .line 1504
    :goto_2
    return-object v0

    .line 1501
    :cond_1
    if-eqz v0, :cond_2

    .line 1503
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    move-object v0, v6

    .line 1504
    goto :goto_2

    .line 1501
    :catchall_0
    move-exception v0

    move-object v0, v7

    :goto_3
    if-eqz v0, :cond_3

    .line 1503
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_3
    move-object v0, v6

    .line 1504
    goto :goto_2

    .line 1501
    :catchall_1
    move-exception v1

    goto :goto_3

    :catch_1
    move-exception v0

    move-object v0, v7

    goto :goto_1
.end method

.method private _handlePushRegistration(Landroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 526
    const-string v0, "registration_id"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 529
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isPushDisabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 531
    const-string v0, "GCM registered but push disabled: removing id"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 533
    invoke-direct {p0, v2}, Lcom/localytics/android/AnalyticsHandler;->_setPushID(Ljava/lang/String;)V

    .line 554
    :cond_0
    :goto_0
    return-void

    .line 536
    :cond_1
    const-string v1, "error"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 538
    const-string v0, "GCM registration failed"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    goto :goto_0

    .line 541
    :cond_2
    const-string v1, "unregistered"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 543
    const-string v0, "GCM unregistered: removing id"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 545
    invoke-direct {p0, v2}, Lcom/localytics/android/AnalyticsHandler;->_setPushID(Ljava/lang/String;)V

    goto :goto_0

    .line 548
    :cond_3
    if-eqz v0, :cond_0

    .line 550
    const-string v1, "GCM registered, new id: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 552
    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_setPushID(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private _isOptedOut()Z
    .locals 9

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 1599
    .line 1602
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "opt_out"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1604
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1606
    const-string v0, "opt_out"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-eqz v0, :cond_1

    move v0, v6

    .line 1611
    :goto_0
    if-eqz v1, :cond_0

    .line 1613
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1618
    :cond_0
    :goto_1
    return v0

    :cond_1
    move v0, v7

    .line 1606
    goto :goto_0

    .line 1611
    :cond_2
    if-eqz v1, :cond_3

    .line 1613
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_3
    move v0, v7

    .line 1618
    goto :goto_1

    .line 1611
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_2
    if-eqz v1, :cond_4

    .line 1613
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1614
    :cond_4
    throw v0

    .line 1611
    :catchall_1
    move-exception v0

    goto :goto_2
.end method

.method private _isPushDisabled()Z
    .locals 9

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 680
    .line 684
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "push_disabled"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    move v0, v7

    .line 685
    :goto_0
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 687
    const-string v2, "push_disabled"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    .line 688
    if-ne v0, v6, :cond_0

    move v0, v6

    goto :goto_0

    :cond_0
    move v0, v7

    goto :goto_0

    .line 693
    :cond_1
    if-eqz v1, :cond_2

    .line 695
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 696
    :cond_2
    :goto_1
    return v0

    .line 693
    :catchall_0
    move-exception v0

    move-object v1, v8

    move v0, v7

    :goto_2
    if-eqz v1, :cond_2

    .line 695
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 693
    :catchall_1
    move-exception v2

    goto :goto_2
.end method

.method private _isSessionOpen()Z
    .locals 12

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    const-wide/16 v10, 0x0

    const/4 v8, 0x0

    .line 1451
    .line 1456
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "last_session_open_time"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "last_session_close_time"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1457
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1459
    const-string v0, "last_session_open_time"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 1460
    const-string v0, "last_session_close_time"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-wide v2

    .line 1465
    :goto_0
    if-eqz v1, :cond_0

    .line 1467
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1475
    :cond_0
    cmp-long v0, v4, v10

    if-eqz v0, :cond_2

    cmp-long v0, v4, v2

    if-ltz v0, :cond_2

    move v0, v6

    :goto_1
    return v0

    .line 1465
    :catchall_0
    move-exception v0

    move-object v1, v8

    :goto_2
    if-eqz v1, :cond_1

    .line 1467
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1468
    :cond_1
    throw v0

    :cond_2
    move v0, v7

    .line 1475
    goto :goto_1

    .line 1465
    :catchall_1
    move-exception v0

    goto :goto_2

    :cond_3
    move-wide v2, v10

    move-wide v4, v10

    goto :goto_0
.end method

.method private _open()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    .line 1223
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isSessionOpen()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1225
    const-string v0, "Session was already open"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 1278
    :cond_0
    :goto_0
    return-void

    .line 1234
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "last_session_close_time"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 1235
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1237
    const-string v0, "last_session_close_time"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 1239
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sget-wide v8, Lcom/localytics/android/Constants;->SESSION_EXPIRATION:J

    add-long/2addr v2, v8

    cmp-long v0, v4, v2

    if-gez v0, :cond_3

    .line 1241
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/AnalyticsListener;

    const/4 v2, 0x0

    iget-boolean v3, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    const/4 v4, 0x1

    invoke-interface {v0, v2, v3, v4}, Lcom/localytics/android/AnalyticsListener;->localyticsSessionWillOpen(ZZZ)V

    .line 1244
    const-string v0, "Opening old closed session and reconnecting"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1246
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_dequeQueuedCloseSessionTag(Z)V

    .line 1248
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/AnalyticsListener;

    const/4 v2, 0x0

    iget-boolean v3, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    const/4 v4, 0x1

    invoke-interface {v0, v2, v3, v4}, Lcom/localytics/android/AnalyticsListener;->localyticsSessionDidOpen(ZZZ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1272
    :cond_2
    :goto_1
    if-eqz v1, :cond_0

    .line 1274
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 1252
    :cond_3
    :try_start_2
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/AnalyticsListener;

    iget-boolean v2, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    iget-boolean v3, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    const/4 v4, 0x0

    invoke-interface {v0, v2, v3, v4}, Lcom/localytics/android/AnalyticsListener;->localyticsSessionWillOpen(ZZZ)V

    .line 1255
    const-string v0, "Opening new session"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1257
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_dequeQueuedCloseSessionTag(Z)V

    .line 1258
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getAdvertisingInfo(Landroid/content/Context;)Lcom/localytics/android/DatapointHelper$AdvertisingInfo;

    move-result-object v0

    .line 1259
    if-nez v0, :cond_5

    :goto_2
    invoke-direct {p0, v6}, Lcom/localytics/android/AnalyticsHandler;->_setFirstAdvertisingId(Ljava/lang/String;)V

    .line 1260
    const-string v0, "open"

    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_tagEvent(Ljava/lang/String;)V

    .line 1265
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/BaseProvider;->deleteOldFiles(Landroid/content/Context;)V

    .line 1266
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/AnalyticsListener;

    iget-boolean v2, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    iget-boolean v3, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    const/4 v4, 0x0

    invoke-interface {v0, v2, v3, v4}, Lcom/localytics/android/AnalyticsListener;->localyticsSessionDidOpen(ZZZ)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 1272
    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_4

    .line 1274
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1275
    :cond_4
    throw v0

    .line 1259
    :cond_5
    :try_start_3
    iget-object v6, v0, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->id:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 1272
    :catchall_1
    move-exception v0

    move-object v1, v6

    goto :goto_3
.end method

.method private _registerPush(Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 623
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isPushDisabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 625
    const-string v0, "Registering for GCM but push disabled"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 676
    :cond_0
    :goto_0
    return-void

    .line 637
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "sender_id"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "registration_version"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "registration_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 639
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 641
    const-string v0, "sender_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 642
    const-string v0, "registration_version"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 643
    const-string v2, "registration_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v2

    move-object v9, v0

    move-object v0, v2

    move-object v2, v9

    .line 648
    :goto_1
    if-eqz v1, :cond_2

    .line 650
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 656
    :cond_2
    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 660
    invoke-direct {p0, p1, v6}, Lcom/localytics/android/AnalyticsHandler;->_setPushID(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v6

    .line 663
    :cond_3
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 666
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 669
    :cond_4
    const-string v0, "com.google.android.gms.gcm.GoogleCloudMessaging"

    const-string v1, "getInstance"

    new-array v2, v8, [Ljava/lang/Class;

    const-class v3, Landroid/content/Context;

    aput-object v3, v2, v7

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v0, v1, v2, v3}, Lcom/localytics/android/ReflectionUtils;->tryInvokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 670
    if-eqz v0, :cond_0

    .line 672
    sput-object p1, Lcom/localytics/android/PushReceiver;->retrySenderId:Ljava/lang/String;

    .line 673
    const-string v1, "register"

    new-array v2, v8, [Ljava/lang/Class;

    const-class v3, [Ljava/lang/String;

    aput-object v3, v2, v7

    new-array v3, v8, [Ljava/lang/Object;

    new-array v4, v8, [Ljava/lang/String;

    aput-object p1, v4, v7

    aput-object v4, v3, v7

    invoke-static {v0, v1, v2, v3}, Lcom/localytics/android/ReflectionUtils;->tryInvokeInstance(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 648
    :catchall_0
    move-exception v0

    :goto_2
    if-eqz v6, :cond_5

    .line 650
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 651
    :cond_5
    throw v0

    .line 648
    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_2

    :cond_6
    move-object v2, v6

    move-object v0, v6

    move-object v3, v6

    goto :goto_1
.end method

.method private _reuploadFirstSession(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1835
    invoke-virtual {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_replaceAttributionInFirstSession(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1836
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1838
    new-instance v1, Lcom/localytics/android/ReferralUploader;

    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v1, p0, v0, v2}, Lcom/localytics/android/ReferralUploader;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    invoke-virtual {v1}, Lcom/localytics/android/ReferralUploader;->start()V

    .line 1840
    :cond_0
    return-void
.end method

.method private _setCustomDimension(ILjava/lang/String;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 1394
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->getCustomDimensionAttributeKey(I)Ljava/lang/String;

    move-result-object v0

    .line 1395
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1397
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "custom_dimensions"

    const-string v3, "%s = ?"

    new-array v4, v7, [Ljava/lang/Object;

    const-string v5, "custom_dimension_key"

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/String;

    aput-object v0, v4, v6

    invoke-virtual {v1, v2, v3, v4}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1409
    :cond_0
    :goto_0
    return-void

    .line 1401
    :cond_1
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1402
    const-string v2, "custom_dimension_key"

    invoke-virtual {v1, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1403
    const-string v2, "custom_dimension_value"

    invoke-virtual {v1, v2, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1404
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "custom_dimensions"

    sget-object v4, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_CUSTOM_DIMENSION:Ljava/lang/String;

    new-array v5, v7, [Ljava/lang/String;

    aput-object v0, v5, v6

    invoke-virtual {v2, v3, v1, v4, v5}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_0

    .line 1406
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "custom_dimensions"

    invoke-virtual {v0, v2, v1}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0
.end method

.method private _setFirstAdvertisingId(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1330
    .line 1335
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "first_advertising_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1337
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1339
    const-string v0, "first_advertising_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 1344
    :goto_0
    if-eqz v1, :cond_0

    .line 1346
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1351
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 1353
    const-string v0, "First advertising id has already been set before."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1360
    :goto_1
    return-void

    .line 1344
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_2
    if-eqz v1, :cond_1

    .line 1346
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1347
    :cond_1
    throw v0

    .line 1357
    :cond_2
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1358
    const-string v1, "first_advertising_id"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1359
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v6, v6}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1

    .line 1344
    :catchall_1
    move-exception v0

    goto :goto_2

    :cond_3
    move-object v0, v6

    goto :goto_0
.end method

.method private _setIdentifier(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1413
    if-eqz p2, :cond_0

    .line 1414
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p2

    .line 1417
    :cond_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1419
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "identifiers"

    const-string v2, "%s = ?"

    new-array v3, v6, [Ljava/lang/Object;

    const-string v4, "key"

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/String;

    aput-object p1, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1432
    :cond_1
    :goto_0
    const-string v0, "customer_id"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1434
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1435
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1437
    const-string v1, "customer_id"

    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getInstallationId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1438
    const-string v1, "user_type"

    const-string v2, "anonymous"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1445
    :goto_1
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v7, v7}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1447
    :cond_2
    return-void

    .line 1423
    :cond_3
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1424
    const-string v1, "key"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1425
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1426
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "identifiers"

    sget-object v3, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_IDENTIFIER:Ljava/lang/String;

    new-array v4, v6, [Ljava/lang/String;

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 1428
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "identifiers"

    invoke-virtual {v1, v2, v0}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0

    .line 1442
    :cond_4
    const-string v1, "customer_id"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1443
    const-string v1, "user_type"

    const-string v2, "known"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private _setOptedOut(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1624
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isOptedOut()Z

    move-result v0

    if-ne v0, p1, :cond_0

    .line 1639
    :goto_0
    return-void

    .line 1629
    :cond_0
    if-eqz p1, :cond_2

    const-string v0, "opt_out"

    :goto_1
    invoke-direct {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->_tagEvent(Ljava/lang/String;)V

    .line 1631
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isSessionOpen()Z

    move-result v0

    if-eqz v0, :cond_1

    if-eqz p1, :cond_1

    .line 1633
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_close()V

    .line 1636
    :cond_1
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1637
    const-string v1, "opt_out"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1638
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v3, v3}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0

    .line 1629
    :cond_2
    const-string v0, "opt_in"

    goto :goto_1
.end method

.method private _setPushDisabled(I)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 519
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 520
    const-string v1, "push_disabled"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 521
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v3, v3}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 522
    return-void
.end method

.method private _setPushID(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1683
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1684
    const-string v1, "registration_id"

    if-nez p1, :cond_0

    const-string p1, ""

    :cond_0
    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1685
    const-string v1, "registration_version"

    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1686
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v3, v3}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1687
    return-void
.end method

.method private _setPushID(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1691
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1692
    const-string v1, "sender_id"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1693
    const-string v1, "registration_id"

    if-nez p2, :cond_0

    const-string p2, ""

    :cond_0
    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1694
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "info"

    invoke-virtual {v1, v2, v0, v3, v3}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1695
    return-void
.end method

.method private _setReferrerId(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1803
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1808
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "play_attribution"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1810
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1812
    const-string v0, "play_attribution"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1813
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1815
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1816
    const-string v2, "play_attribution"

    invoke-virtual {v0, v2, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1817
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "info"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v0, v4, v5}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1818
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "[REFERRAL] _setReferrerId: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->i(Ljava/lang/String;)I

    .line 1819
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_reuploadFirstSession(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1825
    :cond_0
    if-eqz v1, :cond_1

    .line 1827
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1831
    :cond_1
    return-void

    .line 1825
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_0
    if-eqz v1, :cond_2

    .line 1827
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 1825
    :catchall_1
    move-exception v0

    goto :goto_0
.end method

.method private _tagEvent(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 714
    invoke-direct {p0, p1, v0, v0}, Lcom/localytics/android/AnalyticsHandler;->_tagEvent(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V

    .line 715
    return-void
.end method

.method private _tagEvent(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V
    .locals 23
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Long;",
            ")V"
        }
    .end annotation

    .prologue
    .line 833
    const/16 v16, 0x0

    .line 834
    const/4 v15, 0x0

    .line 835
    :try_start_0
    const-string v14, ""

    .line 836
    const-string v13, ""

    .line 837
    const-string v12, ""

    .line 838
    const/4 v9, 0x0

    .line 839
    new-instance v17, Lorg/json/JSONObject;

    invoke-direct/range {v17 .. v17}, Lorg/json/JSONObject;-><init>()V

    .line 840
    const-wide/16 v10, 0x0

    .line 841
    const-string v2, "dt"

    const-string v3, "h"

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 842
    const-string v2, "u"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 844
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v18

    .line 845
    const-string v2, "phone"

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/telephony/TelephonyManager;

    move-object v8, v0

    .line 846
    new-instance v19, Lorg/json/JSONObject;

    invoke-direct/range {v19 .. v19}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 849
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "info"

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 851
    :try_start_2
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_1f

    .line 853
    const-string v2, "pa"

    const-string v4, "created_time"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    long-to-float v4, v4

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    move-object/from16 v0, v17

    invoke-virtual {v0, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 854
    const-string v2, "next_header_number"

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 855
    const-string v2, "next_session_number"

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    .line 856
    const-string v2, "customer_id"

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 857
    const-string v2, "user_type"

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v3, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 858
    const-string v4, "current_session_uuid"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 859
    const-string v4, "seq"

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 861
    const-string v4, "dt"

    const-string v5, "a"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 862
    const-string v4, "au"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 863
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getAndroidIdHashOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 864
    if-eqz v4, :cond_0

    .line 866
    const-string v5, "du"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 868
    :cond_0
    const-string v4, "lv"

    const-string v5, "androida_3.4.0"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 869
    const-string v4, "av"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 870
    const-string v4, "dp"

    const-string v5, "Android"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 871
    const-string v4, "dll"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 872
    const-string v4, "dlc"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 873
    const-string v4, "nc"

    invoke-virtual {v8}, Landroid/telephony/TelephonyManager;->getNetworkCountryIso()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 874
    const-string v4, "dc"

    invoke-virtual {v8}, Landroid/telephony/TelephonyManager;->getSimCountryIso()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 875
    const-string v4, "dma"

    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getManufacturer()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 876
    const-string v4, "dmo"

    sget-object v5, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 877
    const-string v4, "dov"

    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 878
    const-string v4, "nca"

    invoke-virtual {v8}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 879
    const-string v4, "dac"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/localytics/android/DatapointHelper;->getNetworkType(Landroid/telephony/TelephonyManager;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 880
    const-string v4, "iu"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v5}, Lcom/localytics/android/LocalyticsDao;->getInstallationId()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 881
    const-string v4, "fb_attribution"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 882
    if-eqz v4, :cond_1

    .line 884
    const-string v5, "fbat"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 886
    :cond_1
    const-string v4, "registration_id"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 887
    if-eqz v4, :cond_2

    .line 889
    const-string v5, "push"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 891
    :cond_2
    const-string v4, "first_android_id"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 892
    if-eqz v4, :cond_3

    .line 894
    const-string v5, "aid"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 896
    :cond_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getAndroidIdOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 897
    const-string v5, "caid"

    if-nez v4, :cond_4

    sget-object v4, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :cond_4
    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 899
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getAdvertisingInfo(Landroid/content/Context;)Lcom/localytics/android/DatapointHelper$AdvertisingInfo;

    move-result-object v8

    .line 900
    const-string v5, "lad"

    if-eqz v8, :cond_10

    iget-boolean v4, v8, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->limitAdTracking:Z

    if-eqz v4, :cond_10

    const/4 v4, 0x1

    :goto_0
    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 901
    const-string v4, "first_advertising_id"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 902
    if-eqz v4, :cond_5

    .line 904
    const-string v5, "gadid"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 906
    :cond_5
    if-eqz v8, :cond_6

    iget-object v4, v8, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->id:Ljava/lang/String;

    if-eqz v4, :cond_6

    .line 908
    const-string v4, "gcadid"

    iget-object v5, v8, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->id:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 911
    :cond_6
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v4

    .line 912
    invoke-static {v4}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v5

    .line 913
    invoke-virtual {v4, v5}, Ljava/util/TimeZone;->inDaylightTime(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-virtual {v4}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v5

    invoke-virtual {v4}, Ljava/util/TimeZone;->getDSTSavings()I

    move-result v4

    add-int/2addr v4, v5

    .line 914
    :goto_1
    const-string v5, "tz"

    int-to-long v12, v4

    const-wide/16 v14, 0x3e8

    div-long/2addr v12, v14

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 916
    const-string v4, "package_name"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 917
    if-eqz v4, :cond_7

    .line 919
    const-string v5, "pkg"

    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 921
    :cond_7
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getSerialNumberHashOrNull()Ljava/lang/String;

    move-result-object v4

    .line 922
    const-string v5, "dms"

    if-nez v4, :cond_8

    sget-object v4, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :cond_8
    move-object/from16 v0, v19

    invoke-virtual {v0, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 923
    const-string v4, "dsdk"

    sget v5, Lcom/localytics/android/Constants;->CURRENT_API_LEVEL:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 924
    const-string v4, "play_attribution"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 925
    if-eqz v11, :cond_9

    .line 927
    const-string v4, "aurl"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 929
    :cond_9
    const-string v4, "last_session_open_time"

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v4

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 931
    const/4 v12, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v11, v1, v8, v12}, Lcom/localytics/android/AnalyticsHandler;->_updateHeaderForTestModeAttribution(Ljava/lang/String;Lorg/json/JSONObject;Lcom/localytics/android/DatapointHelper$AdvertisingInfo;Z)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move v8, v9

    move v9, v10

    move-object/from16 v22, v7

    move-object v7, v6

    move-object v6, v2

    move-object/from16 v2, v22

    .line 936
    :goto_2
    if-eqz v3, :cond_a

    .line 938
    :try_start_3
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 942
    :cond_a
    const-string v3, "attrs"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v3, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 944
    invoke-direct/range {p0 .. p0}, Lcom/localytics/android/AnalyticsHandler;->_getIdentifiers()Lorg/json/JSONObject;

    move-result-object v3

    .line 946
    invoke-virtual {v3}, Lorg/json/JSONObject;->length()I

    move-result v10

    if-lez v10, :cond_b

    .line 948
    const-string v10, "ids"

    move-object/from16 v0, v17

    invoke-virtual {v0, v10, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 951
    :cond_b
    new-instance v10, Landroid/content/ContentValues;

    invoke-direct {v10}, Landroid/content/ContentValues;-><init>()V

    .line 952
    new-instance v11, Landroid/content/ContentValues;

    invoke-direct {v11}, Landroid/content/ContentValues;-><init>()V

    .line 954
    const-string v12, "next_header_number"

    add-int/lit8 v9, v9, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v12, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 957
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9}, Lorg/json/JSONObject;-><init>()V

    .line 958
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 959
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v14

    invoke-virtual {v14}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v14

    .line 960
    const-string v15, "open"

    move-object/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_14

    .line 962
    const-string v2, "dt"

    const-string v15, "s"

    invoke-virtual {v9, v2, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 963
    const-string v2, "ct"

    const-wide/16 v18, 0x3e8

    div-long v18, v12, v18

    move-wide/from16 v0, v18

    long-to-double v0, v0

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Math;->round(D)J

    move-result-wide v18

    move-wide/from16 v0, v18

    invoke-virtual {v9, v2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 964
    const-string v2, "u"

    invoke-virtual {v9, v2, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 966
    sub-long v18, v12, v4

    .line 967
    const-wide/16 v20, 0x0

    cmp-long v2, v4, v20

    if-nez v2, :cond_13

    .line 969
    const-string v2, "sl"

    const-wide/16 v4, 0x0

    invoke-virtual {v9, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    .line 979
    :cond_c
    :goto_3
    const-string v2, "nth"

    invoke-virtual {v9, v2, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 981
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v3, v7, v6}, Lcom/localytics/android/AnalyticsHandler;->_addLocationIDsAndCustomDimensions(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 983
    const-string v2, "%s\n%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v9}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 984
    const-string v3, "blob"

    invoke-virtual {v11, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 985
    const-string v3, "upload_format"

    sget-object v4, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v4}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v11, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 987
    const-string v3, "last_session_open_time"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v10, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 988
    const-string v3, "next_session_number"

    add-int/lit8 v4, v8, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v10, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 989
    const-string v3, "current_session_uuid"

    invoke-virtual {v10, v3, v14}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 990
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    if-eqz v3, :cond_d

    .line 992
    const-string v3, "first_open_event_blob"

    invoke-virtual {v10, v3, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1063
    :cond_d
    :goto_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "info"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v10, v4, v5}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1064
    invoke-virtual {v11}, Landroid/content/ContentValues;->size()I

    move-result v2

    if-lez v2, :cond_e

    .line 1066
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "events"

    invoke-virtual {v2, v3, v11}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1069
    :cond_e
    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "open"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "close"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "opt_in"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string v4, "opt_out"

    aput-object v4, v2, v3

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_f

    .line 1071
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/localytics/android/AnalyticsHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v2, Lcom/localytics/android/AnalyticsListener;

    if-nez p3, :cond_1e

    const-wide/16 v4, 0x0

    :goto_5
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-interface {v2, v0, v1, v4, v5}, Lcom/localytics/android/AnalyticsListener;->localyticsDidTagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 1077
    :cond_f
    :goto_6
    return-void

    .line 900
    :cond_10
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 913
    :cond_11
    :try_start_4
    invoke-virtual {v4}, Ljava/util/TimeZone;->getRawOffset()I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result v4

    goto/16 :goto_1

    .line 936
    :catchall_0
    move-exception v2

    move-object v3, v9

    :goto_7
    if-eqz v3, :cond_12

    .line 938
    :try_start_5
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 939
    :cond_12
    throw v2

    .line 1077
    :catch_0
    move-exception v2

    goto :goto_6

    .line 971
    :cond_13
    const-wide/16 v4, 0x0

    cmp-long v2, v18, v4

    if-lez v2, :cond_c

    .line 973
    const-string v2, "sl"

    const-wide/16 v4, 0x3e8

    div-long v4, v18, v4

    long-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    invoke-virtual {v9, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    goto/16 :goto_3

    .line 995
    :cond_14
    const-string v8, "close"

    move-object/from16 v0, p1

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_16

    .line 997
    const-string v8, "dt"

    const-string v15, "c"

    invoke-virtual {v9, v8, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 998
    const-string v8, "u"

    invoke-virtual {v9, v8, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 999
    const-string v8, "su"

    invoke-virtual {v9, v8, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1000
    const-string v2, "ss"

    const-wide/16 v14, 0x3e8

    div-long v14, v4, v14

    long-to-double v14, v14

    invoke-static {v14, v15}, Ljava/lang/Math;->round(D)J

    move-result-wide v14

    invoke-virtual {v9, v2, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1001
    const-string v2, "ct"

    const-wide/16 v14, 0x3e8

    div-long v14, v12, v14

    long-to-double v14, v14

    invoke-static {v14, v15}, Ljava/lang/Math;->round(D)J

    move-result-wide v14

    invoke-virtual {v9, v2, v14, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1002
    const-string v2, "ctl"

    sub-long v4, v12, v4

    const-wide/16 v14, 0x3e8

    div-long/2addr v4, v14

    long-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    invoke-virtual {v9, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1004
    new-instance v2, Lorg/json/JSONArray;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    invoke-direct {v2, v4}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .line 1005
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lez v4, :cond_15

    .line 1007
    const-string v4, "fl"

    invoke-virtual {v9, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1010
    :cond_15
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v3, v7, v6}, Lcom/localytics/android/AnalyticsHandler;->_addLocationIDsAndCustomDimensions(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 1012
    const-string v2, "last_session_close_time"

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v10, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1013
    const-string v2, "queued_close_session_blob"

    const-string v3, "%s\n%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual {v9}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v10, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1014
    const-string v2, "queued_close_session_blob_upload_format"

    sget-object v3, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v3}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v10, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    goto/16 :goto_4

    .line 1016
    :cond_16
    const-string v4, "opt_in"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_17

    const-string v4, "opt_out"

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1a

    .line 1018
    :cond_17
    const-string v2, "dt"

    const-string v3, "o"

    invoke-virtual {v9, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1019
    const-string v2, "u"

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1020
    const-string v3, "out"

    const-string v2, "opt_out"

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_19

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_8
    invoke-virtual {v9, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1021
    const-string v2, "ct"

    const-wide/16 v4, 0x3e8

    div-long v4, v12, v4

    long-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->round(D)J

    move-result-wide v4

    invoke-virtual {v9, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1059
    :cond_18
    :goto_9
    const-string v2, "blob"

    const-string v3, "%s\n%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual/range {v17 .. v17}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-virtual {v9}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v11, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1060
    const-string v2, "upload_format"

    sget-object v3, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->V2:Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;

    invoke-virtual {v3}, Lcom/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat;->getValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v11, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    goto/16 :goto_4

    .line 1020
    :cond_19
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_8

    .line 1031
    :cond_1a
    const-string v4, "dt"

    const-string v5, "e"

    invoke-virtual {v9, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1032
    const-string v4, "ct"

    const-wide/16 v20, 0x3e8

    div-long v12, v12, v20

    long-to-double v12, v12

    invoke-static {v12, v13}, Ljava/lang/Math;->round(D)J

    move-result-wide v12

    invoke-virtual {v9, v4, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 1033
    const-string v4, "u"

    invoke-virtual {v9, v4, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1034
    const-string v4, "su"

    invoke-direct/range {p0 .. p0}, Lcom/localytics/android/AnalyticsHandler;->_isSessionOpen()Z

    move-result v5

    if-eqz v5, :cond_1c

    :goto_a
    invoke-virtual {v9, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1035
    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1d

    .line 1037
    const-string v2, "n"

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v5

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v9, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1047
    :goto_b
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v12, 0x0

    cmp-long v2, v4, v12

    if-eqz v2, :cond_1b

    .line 1049
    const-string v2, "v"

    move-object/from16 v0, p3

    invoke-virtual {v9, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1052
    :cond_1b
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v3, v7, v6}, Lcom/localytics/android/AnalyticsHandler;->_addLocationIDsAndCustomDimensions(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V

    .line 1054
    if-eqz p2, :cond_18

    .line 1056
    const-string v2, "attrs"

    new-instance v3, Lorg/json/JSONObject;

    move-object/from16 v0, p2

    invoke-direct {v3, v0}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-virtual {v9, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto/16 :goto_9

    .line 1034
    :cond_1c
    const-string v2, ""

    goto :goto_a

    .line 1041
    :cond_1d
    const-string v2, "n"

    move-object/from16 v0, p1

    invoke-virtual {v9, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_b

    .line 1071
    :cond_1e
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Long;->longValue()J
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    move-result-wide v4

    goto/16 :goto_5

    .line 936
    :catchall_1
    move-exception v2

    goto/16 :goto_7

    :cond_1f
    move-wide v4, v10

    move-object v6, v12

    move-object v7, v13

    move-object v2, v14

    move v8, v15

    move/from16 v9, v16

    goto/16 :goto_2
.end method

.method private _tagScreen(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1199
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isSessionOpen()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1201
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1203
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1210
    :cond_1
    :goto_0
    return-void

    .line 1208
    :cond_2
    const-string v0, "Screen not tagged because a session is not open"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    goto :goto_0
.end method

.method private _updateHeaderForTestModeAttribution(Ljava/lang/String;Lorg/json/JSONObject;Lcom/localytics/android/DatapointHelper$AdvertisingInfo;Z)V
    .locals 8

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 1082
    iget-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mSentReferrerTestMode:Z

    if-nez v0, :cond_6

    .line 1090
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 1092
    invoke-static {p1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v3, "[&]"

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 1093
    array-length v5, v4

    move v3, v2

    :goto_0
    if-ge v3, v5, :cond_3

    aget-object v0, v4, v3

    .line 1095
    const-string v6, "[=]"

    invoke-virtual {v0, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1096
    array-length v6, v0

    if-le v6, v1, :cond_1

    .line 1098
    aget-object v6, v0, v2

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 1099
    const-string v7, "localytics_test_mode"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    const-string v6, "1"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    const-string v6, "true"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mReferrerTestModeEnabled:Z

    .line 1093
    :cond_1
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_0

    :cond_2
    move v0, v2

    .line 1099
    goto :goto_1

    .line 1103
    :cond_3
    if-nez p4, :cond_4

    iget-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    if-eqz v0, :cond_6

    :cond_4
    iget-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mReferrerTestModeEnabled:Z

    if-eqz v0, :cond_6

    .line 1107
    :try_start_0
    const-string v0, "[REFERRAL] using fake id for attribution test mode"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->i(Ljava/lang/String;)I

    .line 1108
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    invoke-virtual {v0}, Ljava/security/SecureRandom;->nextLong()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;

    move-result-object v0

    .line 1109
    const-string v1, "aid"

    invoke-virtual {p2, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1110
    const-string v1, "du"

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getSha256_buggy(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1111
    const-string v1, "caid"

    invoke-virtual {p2, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1112
    if-eqz p3, :cond_5

    .line 1114
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1115
    const-string v1, "gadid"

    invoke-virtual {p2, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1116
    const-string v1, "gcadid"

    invoke-virtual {p2, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1118
    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mSentReferrerTestMode:Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1126
    :cond_6
    :goto_2
    return-void

    .line 1122
    :catch_0
    move-exception v0

    const-class v0, Lorg/json/JSONException;

    const-string v1, "Exception adding values to object"

    invoke-static {v0, v1}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    goto :goto_2
.end method

.method static synthetic access$000(Lcom/localytics/android/AnalyticsHandler;)Z
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isPushDisabled()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Lcom/localytics/android/AnalyticsHandler;I)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_setPushDisabled(I)V

    return-void
.end method

.method static synthetic access$1100(Lcom/localytics/android/AnalyticsHandler;Z)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_setOptedOut(Z)V

    return-void
.end method

.method static synthetic access$1200(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_registerPush(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1300(Lcom/localytics/android/AnalyticsHandler;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_handlePushRegistration(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$1400(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_setReferrerId(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1500(Lcom/localytics/android/AnalyticsHandler;I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_getCustomDimension(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1600()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/localytics/android/AnalyticsHandler;->PROJECTION_SET_IDENTIFIER:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1700()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_IDENTIFIER:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/localytics/android/AnalyticsHandler;)Z
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_isOptedOut()Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/localytics/android/AnalyticsHandler;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_open()V

    return-void
.end method

.method static synthetic access$400(Lcom/localytics/android/AnalyticsHandler;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/localytics/android/AnalyticsHandler;->_close()V

    return-void
.end method

.method static synthetic access$500(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1, p2, p3}, Lcom/localytics/android/AnalyticsHandler;->_tagEvent(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V

    return-void
.end method

.method static synthetic access$600(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_tagScreen(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$700(Lcom/localytics/android/AnalyticsHandler;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/AnalyticsHandler;->_setCustomDimension(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$800(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/AnalyticsHandler;->_setIdentifier(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$900(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/localytics/android/AnalyticsHandler;->_setPushID(Ljava/lang/String;)V

    return-void
.end method

.method private getCustomDimensionAttributeKey(I)Ljava/lang/String;
    .locals 4

    .prologue
    .line 768
    if-ltz p1, :cond_0

    const/16 v0, 0xa

    if-gt p1, v0, :cond_0

    .line 770
    const-string v0, "%s%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "custom_dimension_"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 774
    :goto_0
    return-object v0

    :cond_0
    const-class v0, Ljava/lang/IndexOutOfBoundsException;

    const-string v1, "Custom dimension index cannot exceed 10"

    invoke-static {v0, v1}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method protected _deleteUploadedData(I)V
    .locals 4

    .prologue
    .line 514
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "events"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "_id <= "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 515
    return-void
.end method

.method protected _getDataToUpload()Ljava/util/TreeMap;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 590
    new-instance v6, Ljava/util/TreeMap;

    invoke-direct {v6}, Ljava/util/TreeMap;-><init>()V

    .line 594
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "events"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "_id ASC"

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    .line 596
    :goto_0
    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v6}, Ljava/util/TreeMap;->size()I

    move-result v1

    const/16 v2, 0x64

    if-ge v1, v2, :cond_1

    .line 598
    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 599
    const-string v2, "blob"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 600
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v6, v1, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 605
    :catchall_0
    move-exception v1

    :goto_1
    if-eqz v0, :cond_0

    .line 607
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_0
    move-object v0, v6

    .line 608
    :goto_2
    return-object v0

    .line 605
    :cond_1
    if-eqz v0, :cond_2

    .line 607
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_2
    move-object v0, v6

    .line 608
    goto :goto_2

    .line 605
    :catchall_1
    move-exception v0

    move-object v0, v7

    goto :goto_1
.end method

.method protected _getMaxRowToUpload()I
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 565
    .line 569
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "events"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "_id ASC"

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 570
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToLast()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 572
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    .line 577
    :goto_0
    if-eqz v1, :cond_0

    .line 579
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 580
    :cond_0
    :goto_1
    return v0

    .line 577
    :catchall_0
    move-exception v0

    move-object v0, v7

    :goto_2
    if-eqz v0, :cond_1

    .line 579
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_1
    move v0, v6

    .line 580
    goto :goto_1

    .line 577
    :catchall_1
    move-exception v0

    move-object v0, v1

    goto :goto_2

    :cond_2
    move v0, v6

    goto :goto_0
.end method

.method protected _init()V
    .locals 3

    .prologue
    .line 1704
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    if-nez v0, :cond_0

    .line 1706
    new-instance v0, Lcom/localytics/android/AnalyticsProvider;

    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->siloName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, v1, v2}, Lcom/localytics/android/AnalyticsProvider;-><init>(Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    iput-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    .line 1709
    :cond_0
    invoke-virtual {p0}, Lcom/localytics/android/AnalyticsHandler;->_initApiKey()V

    .line 1710
    return-void
.end method

.method protected _initApiKey()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 1714
    .line 1717
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/DatapointHelper;->getAppVersion(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    .line 1718
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "app_version"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "uuid"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "next_session_number"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string v4, "customer_id"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    move-result-object v1

    .line 1720
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1723
    const-string v0, "Loading details for API key %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1725
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1726
    const-string v2, "app_version"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1728
    const-string v2, "app_version"

    invoke-virtual {v0, v2, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1729
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/localytics/android/AnalyticsHandler;->mAppWasUpgraded:Z

    .line 1732
    :cond_0
    invoke-virtual {v0}, Landroid/content/ContentValues;->size()I

    move-result v2

    if-eqz v2, :cond_1

    .line 1734
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v3, "info"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v0, v4, v5}, Lcom/localytics/android/BaseProvider;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1737
    :cond_1
    const-string v0, "next_session_number"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v7, :cond_4

    move v0, v7

    :goto_0
    iput-boolean v0, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    .line 1738
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const-string v2, "uuid"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/localytics/android/LocalyticsDao;->setInstallationId(Ljava/lang/String;)V

    .line 1739
    const-string v0, "customer_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1740
    const-class v2, Lcom/localytics/android/LocalyticsManager;

    monitor-enter v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 1742
    :try_start_2
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory(Z)Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_2

    .line 1744
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3, v0}, Lcom/localytics/android/LocalyticsDao;->setCustomerIdInMemory(Ljava/lang/String;)V

    .line 1746
    :cond_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1786
    :goto_1
    if-eqz v1, :cond_3

    .line 1788
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1790
    :cond_3
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInitiatedLatch()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 1793
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    invoke-virtual {v0}, Lcom/localytics/android/BaseProvider;->vacuumIfNecessary()V

    .line 1794
    return-void

    :cond_4
    move v0, v8

    .line 1737
    goto :goto_0

    .line 1746
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1786
    :catchall_1
    move-exception v0

    :goto_2
    if-eqz v1, :cond_5

    .line 1788
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1790
    :cond_5
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInitiatedLatch()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0

    .line 1747
    :cond_6
    :try_start_5
    const-string v0, "Performing first-time initialization for new API key %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1753
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1754
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v2, v0}, Lcom/localytics/android/LocalyticsDao;->setInstallationId(Ljava/lang/String;)V

    .line 1755
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1756
    const-string v3, "api_key"

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getApiKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1757
    const-string v3, "uuid"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1758
    const-string v3, "created_time"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1759
    const-string v3, "opt_out"

    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1760
    const-string v3, "push_disabled"

    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1761
    const-string v3, "customer_id"

    invoke-virtual {v2, v3, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1762
    const-string v3, "user_type"

    const-string v4, "anonymous"

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1763
    const-string v3, "fb_attribution"

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getFBAttribution(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1764
    const-string v3, "first_android_id"

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getAndroidIdOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1765
    const-string v3, "package_name"

    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1766
    const-string v3, "app_version"

    invoke-virtual {v2, v3, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1767
    const-string v3, "next_session_number"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1768
    const-string v3, "next_header_number"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1769
    const-string v3, "last_session_open_time"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1770
    const-string v3, "last_session_close_time"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1771
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v4, "info"

    invoke-virtual {v3, v4, v2}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 1773
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/localytics/android/AnalyticsHandler;->mFirstSessionEver:Z

    .line 1775
    const-class v2, Lcom/localytics/android/LocalyticsManager;

    monitor-enter v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1777
    :try_start_6
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    const/4 v4, 0x1

    invoke-interface {v3, v4}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory(Z)Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_7

    .line 1779
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3, v0}, Lcom/localytics/android/LocalyticsDao;->setCustomerIdInMemory(Ljava/lang/String;)V

    .line 1781
    :cond_7
    monitor-exit v2

    goto/16 :goto_1

    :catchall_2
    move-exception v0

    monitor-exit v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    :try_start_7
    throw v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 1786
    :catchall_3
    move-exception v0

    move-object v1, v6

    goto/16 :goto_2
.end method

.method protected _onUploadCompleted(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 559
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    invoke-virtual {v0}, Lcom/localytics/android/BaseProvider;->vacuumIfNecessary()V

    .line 560
    return-void
.end method

.method _replaceAttributionInFirstSession(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1846
    .line 1849
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "info"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "first_open_event_blob"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1851
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1853
    const-string v0, "first_open_event_blob"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1854
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 1859
    const-string v2, "[\n]"

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v2

    .line 1862
    :try_start_2
    new-instance v3, Lorg/json/JSONObject;

    const/4 v0, 0x0

    aget-object v0, v2, v0

    invoke-direct {v3, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1863
    const-string v0, "attrs"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 1865
    iget-object v4, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v4}, Lcom/localytics/android/LocalyticsDao;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/localytics/android/DatapointHelper;->getAdvertisingInfo(Landroid/content/Context;)Lcom/localytics/android/DatapointHelper$AdvertisingInfo;

    move-result-object v4

    .line 1866
    const/4 v5, 0x1

    invoke-direct {p0, p1, v0, v4, v5}, Lcom/localytics/android/AnalyticsHandler;->_updateHeaderForTestModeAttribution(Ljava/lang/String;Lorg/json/JSONObject;Lcom/localytics/android/DatapointHelper$AdvertisingInfo;Z)V

    .line 1868
    const-string v4, "aurl"

    invoke-virtual {v0, v4, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1869
    const-string v0, "%s\n%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v4, v5

    const/4 v3, 0x1

    const/4 v5, 0x1

    aget-object v2, v2, v5

    aput-object v2, v4, v3

    invoke-static {v0, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v0

    .line 1880
    if-eqz v1, :cond_0

    .line 1882
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1886
    :cond_0
    :goto_0
    return-object v0

    .line 1871
    :catch_0
    move-exception v0

    .line 1873
    :try_start_3
    const-string v2, "JSONException"

    invoke-static {v2, v0}, Lcom/localytics/android/Localytics$Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1880
    :cond_1
    if-eqz v1, :cond_2

    .line 1882
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_2
    move-object v0, v6

    .line 1886
    goto :goto_0

    .line 1880
    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v6, :cond_3

    .line 1882
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0

    .line 1880
    :catchall_1
    move-exception v0

    move-object v6, v1

    goto :goto_1
.end method

.method closeSession()V
    .locals 1

    .prologue
    .line 1570
    const/16 v0, 0x66

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1571
    return-void
.end method

.method getCustomDimension(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 719
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$15;

    invoke-direct {v0, p0, p1}, Lcom/localytics/android/AnalyticsHandler$15;-><init>(Lcom/localytics/android/AnalyticsHandler;I)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getString(Ljava/util/concurrent/Callable;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getIdentifier(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1538
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$17;

    invoke-direct {v0, p0, p1}, Lcom/localytics/android/AnalyticsHandler$17;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getString(Ljava/util/concurrent/Callable;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getIdentifiers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 188
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$2;

    invoke-direct {v0, p0}, Lcom/localytics/android/AnalyticsHandler$2;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getMap(Ljava/util/concurrent/Callable;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method getPushRegistrationID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 780
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$16;

    invoke-direct {v0, p0}, Lcom/localytics/android/AnalyticsHandler$16;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getString(Ljava/util/concurrent/Callable;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getUploadThread(Ljava/util/TreeMap;Ljava/lang/String;)Lcom/localytics/android/BaseUploadThread;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/localytics/android/BaseUploadThread;"
        }
    .end annotation

    .prologue
    .line 618
    new-instance v0, Lcom/localytics/android/AnalyticsUploadHandler;

    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/localytics/android/AnalyticsUploadHandler;-><init>(Lcom/localytics/android/BaseHandler;Ljava/util/TreeMap;Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    return-object v0
.end method

.method protected handleMessageExtended(Landroid/os/Message;)V
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 267
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 505
    :pswitch_0
    invoke-super {p0, p1}, Lcom/localytics/android/BaseHandler;->handleMessageExtended(Landroid/os/Message;)V

    .line 509
    :goto_0
    return-void

    .line 271
    :pswitch_1
    const-string v0, "Analytics handler received MESSAGE_OPEN"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 273
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v1, Lcom/localytics/android/AnalyticsHandler$3;

    invoke-direct {v1, p0}, Lcom/localytics/android/AnalyticsHandler$3;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {v0, v1}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 291
    :pswitch_2
    const-string v0, "Analytics handler received MESSAGE_CLOSE"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 293
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v1, Lcom/localytics/android/AnalyticsHandler$4;

    invoke-direct {v1, p0}, Lcom/localytics/android/AnalyticsHandler$4;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {v0, v1}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 311
    :pswitch_3
    const-string v0, "Analytics handler received MESSAGE_TAG_EVENT"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 313
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    .line 314
    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/String;

    .line 316
    aget-object v2, v0, v2

    check-cast v2, Ljava/util/Map;

    .line 317
    const/4 v3, 0x2

    aget-object v0, v0, v3

    check-cast v0, Ljava/lang/Long;

    .line 319
    iget-object v3, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v4, Lcom/localytics/android/AnalyticsHandler$5;

    invoke-direct {v4, p0, v1, v2, v0}, Lcom/localytics/android/AnalyticsHandler$5;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V

    invoke-virtual {v3, v4}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 337
    :pswitch_4
    const-string v0, "Analytics handler received MESSAGE_TAG_SCREEN"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 339
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 341
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$6;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$6;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 359
    :pswitch_5
    const-string v0, "Analytics handler received MESSAGE_SET_CUSTOM_DIMENSION"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 361
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    .line 362
    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 363
    aget-object v0, v0, v2

    check-cast v0, Ljava/lang/String;

    .line 365
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v3, Lcom/localytics/android/AnalyticsHandler$7;

    invoke-direct {v3, p0, v1, v0}, Lcom/localytics/android/AnalyticsHandler$7;-><init>(Lcom/localytics/android/AnalyticsHandler;ILjava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 377
    :pswitch_6
    const-string v0, "Analytics handler received MESSAGE_SET_IDENTIFIER"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 379
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    .line 380
    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/String;

    .line 381
    aget-object v0, v0, v2

    check-cast v0, Ljava/lang/String;

    .line 383
    iget-object v2, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v3, Lcom/localytics/android/AnalyticsHandler$8;

    invoke-direct {v3, p0, v1, v0}, Lcom/localytics/android/AnalyticsHandler$8;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 395
    :pswitch_7
    const-string v0, "Analytics handler received MESSAGE_SET_LOCATION"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 397
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/location/Location;

    sput-object v0, Lcom/localytics/android/AnalyticsHandler;->sLastLocation:Landroid/location/Location;

    goto/16 :goto_0

    .line 402
    :pswitch_8
    const-string v0, "Analytics handler received MESSAGE_SET_PUSH_REGID"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 404
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 406
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$9;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$9;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 425
    :pswitch_9
    const-string v0, "Analytics handler received MESSAGE_DISABLE_PUSH"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 427
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 429
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$10;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$10;-><init>(Lcom/localytics/android/AnalyticsHandler;I)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 441
    :pswitch_a
    const-string v0, "Analytics handler received MESSAGE_OPT_OUT"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 443
    iget v0, p1, Landroid/os/Message;->arg1:I

    if-eqz v0, :cond_0

    move v0, v2

    .line 445
    :goto_1
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$11;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$11;-><init>(Lcom/localytics/android/AnalyticsHandler;Z)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    :cond_0
    move v0, v1

    .line 443
    goto :goto_1

    .line 457
    :pswitch_b
    const-string v0, "Analytics handler received MESSAGE_REGISTER_PUSH"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 459
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 461
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$12;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$12;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 473
    :pswitch_c
    const-string v0, "Analytics handler received MESSAGE_HANDLE_PUSH_REGISTRATION"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 475
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/content/Intent;

    .line 477
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$13;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$13;-><init>(Lcom/localytics/android/AnalyticsHandler;Landroid/content/Intent;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 489
    :pswitch_d
    const-string v0, "Analytics handler received MESSAGE_SET_REFERRERID"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 491
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 493
    iget-object v1, p0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v2, Lcom/localytics/android/AnalyticsHandler$14;

    invoke-direct {v2, p0, v0}, Lcom/localytics/android/AnalyticsHandler$14;-><init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 267
    nop

    :pswitch_data_0
    .packed-switch 0x65
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_6
        :pswitch_7
        :pswitch_5
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_0
        :pswitch_9
        :pswitch_8
        :pswitch_d
    .end packed-switch
.end method

.method handleRegistration(Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 1891
    const/16 v0, 0x6e

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1892
    return-void
.end method

.method isOptedOut()Z
    .locals 1

    .prologue
    .line 1666
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$18;

    invoke-direct {v0, p0}, Lcom/localytics/android/AnalyticsHandler$18;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getBool(Ljava/util/concurrent/Callable;)Z

    move-result v0

    return v0
.end method

.method isPushDisabled()Z
    .locals 1

    .prologue
    .line 163
    new-instance v0, Lcom/localytics/android/AnalyticsHandler$1;

    invoke-direct {v0, p0}, Lcom/localytics/android/AnalyticsHandler$1;-><init>(Lcom/localytics/android/AnalyticsHandler;)V

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->getBool(Ljava/util/concurrent/Callable;)Z

    move-result v0

    return v0
.end method

.method openSession()V
    .locals 1

    .prologue
    .line 1513
    const/16 v0, 0x65

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1514
    return-void
.end method

.method registerPush(Ljava/lang/String;J)V
    .locals 2

    .prologue
    .line 1699
    const/16 v0, 0x6d

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/localytics/android/AnalyticsHandler;->queueMessageDelayed(Landroid/os/Message;J)Z

    .line 1700
    return-void
.end method

.method setCustomDimension(ILjava/lang/String;)V
    .locals 4

    .prologue
    .line 1518
    if-ltz p1, :cond_0

    const/16 v0, 0xa

    if-lt p1, v0, :cond_1

    .line 1520
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Only valid dimensions are 0 - 9"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1523
    :cond_1
    const/16 v0, 0x6b

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1524
    return-void
.end method

.method setIdentifier(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1528
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1530
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "key cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1533
    :cond_0
    const/16 v0, 0x69

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1534
    return-void
.end method

.method setLocation(Landroid/location/Location;)V
    .locals 2

    .prologue
    .line 1594
    const/16 v0, 0x6a

    new-instance v1, Landroid/location/Location;

    invoke-direct {v1, p1}, Landroid/location/Location;-><init>(Landroid/location/Location;)V

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1595
    return-void
.end method

.method setOptedOut(Z)V
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 1659
    const-string v2, "Requested opt-out state is %b"

    new-array v3, v0, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/localytics/android/Localytics$Log;->v(Ljava/lang/String;)I

    .line 1661
    const/16 v2, 0x6c

    if-eqz p1, :cond_0

    :goto_0
    invoke-virtual {p0, v2, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1662
    return-void

    :cond_0
    move v0, v1

    .line 1661
    goto :goto_0
.end method

.method setPushDisabled(Z)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 1678
    const/16 v2, 0x70

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v2, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1679
    return-void

    :cond_0
    move v0, v1

    .line 1678
    goto :goto_0
.end method

.method setPushRegistrationId(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 813
    const/16 v0, 0x71

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 814
    return-void
.end method

.method setReferrerId(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1798
    const/16 v0, 0x72

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1799
    return-void
.end method

.method setScreenFlow(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 175
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler;->screenFlow:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    .line 176
    return-void
.end method

.method tagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;J)V"
        }
    .end annotation

    .prologue
    const/16 v7, 0x32

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 224
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 226
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "event cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 229
    :cond_0
    if-eqz p2, :cond_5

    .line 235
    invoke-interface {p2}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 237
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "attributes is empty.  Did the caller make an error?"

    invoke-static {v0, v1}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 240
    :cond_1
    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v0

    if-le v0, v7, :cond_2

    .line 242
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 245
    :cond_2
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 247
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 248
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 250
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 252
    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string v3, "attributes cannot contain null or empty keys"

    invoke-static {v1, v3}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 254
    :cond_4
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 256
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "attributes cannot contain null or empty values"

    invoke-static {v0, v1}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    goto :goto_0

    .line 261
    :cond_5
    const/16 v0, 0x67

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v4

    aput-object p2, v1, v5

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v1, v6

    invoke-virtual {p0, v0, v1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 262
    return-void
.end method

.method tagScreen(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1584
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1586
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "event cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1589
    :cond_0
    const/16 v0, 0x68

    invoke-virtual {p0, v0, p1}, Lcom/localytics/android/AnalyticsHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/AnalyticsHandler;->queueMessage(Landroid/os/Message;)Z

    .line 1590
    return-void
.end method
