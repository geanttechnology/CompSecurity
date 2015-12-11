.class Lcom/localytics/android/ProfileHandler;
.super Lcom/localytics/android/BaseHandler;
.source "SourceFile"


# static fields
.field static final ATTRIBUTE_JSON_KEY_KEY:Ljava/lang/String; = "attr"

.field static final ATTRIBUTE_JSON_OP_KEY:Ljava/lang/String; = "op"

.field static final ATTRIBUTE_JSON_VALUE_KEY:Ljava/lang/String; = "value"

.field private static final MESSAGE_SET_PROFILE_ATTRIBUTE:I = 0x12d


# direct methods
.method constructor <init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V
    .locals 2

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/BaseHandler;-><init>(Lcom/localytics/android/LocalyticsDao;Landroid/os/Looper;)V

    .line 32
    const-string v0, "Profile"

    iput-object v0, p0, Lcom/localytics/android/ProfileHandler;->siloName:Ljava/lang/String;

    .line 33
    new-instance v0, Lcom/localytics/android/ProfileHandler$ProfileListenersSet;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/localytics/android/ProfileHandler$ProfileListenersSet;-><init>(Lcom/localytics/android/ProfileHandler;Lcom/localytics/android/ProfileHandler$1;)V

    iput-object v0, p0, Lcom/localytics/android/ProfileHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    .line 34
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/localytics/android/ProfileHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/ProfileHandler;->queueMessage(Landroid/os/Message;)Z

    .line 35
    return-void
.end method

.method private _setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 332
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 333
    const-string v1, "scope"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    const-string v1, "change"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    const-string v1, "customer_id"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    iget-object v1, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v2, "changes"

    invoke-virtual {v1, v2, v0}, Lcom/localytics/android/BaseProvider;->insert(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 337
    return-void
.end method

.method static synthetic access$100(Lcom/localytics/android/ProfileHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0, p1, p2, p3}, Lcom/localytics/android/ProfileHandler;->_setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static checkAttributeName(Ljava/lang/String;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 265
    if-nez p0, :cond_0

    .line 267
    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "attribute name cannot be null"

    invoke-static {v1, v2}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 288
    :goto_0
    return v0

    .line 270
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 271
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 273
    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "attribute name cannot be empty"

    invoke-static {v1, v2}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    goto :goto_0

    .line 288
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static convertDateToString(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 293
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd"

    invoke-direct {v2, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 294
    instance-of v1, p0, Ljava/util/Date;

    if-eqz v1, :cond_1

    .line 296
    invoke-virtual {v2, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 315
    :cond_0
    :goto_0
    return-object v0

    .line 298
    :cond_1
    instance-of v1, p0, [Ljava/util/Date;

    if-eqz v1, :cond_0

    .line 300
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 301
    check-cast p0, [Ljava/util/Date;

    check-cast p0, [Ljava/util/Date;

    array-length v4, p0

    const/4 v1, 0x0

    :goto_1
    if-ge v1, v4, :cond_3

    aget-object v5, p0, v1

    .line 303
    if-eqz v5, :cond_2

    .line 305
    invoke-virtual {v2, v5}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 301
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 309
    :cond_2
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 312
    :cond_3
    invoke-interface {v3}, Ljava/util/List;->toArray()[Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method private static convertToObjectArray([J)[Ljava/lang/Long;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 320
    array-length v1, p0

    new-array v2, v1, [Ljava/lang/Long;

    .line 322
    array-length v3, p0

    move v1, v0

    :goto_0
    if-ge v0, v3, :cond_0

    aget-wide v4, p0, v0

    .line 324
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v1

    .line 325
    add-int/lit8 v1, v1, 0x1

    .line 322
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 327
    :cond_0
    return-object v2
.end method

.method private saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 164
    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->checkAttributeName(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 168
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 169
    const-string v2, "op"

    invoke-virtual {p1}, Lcom/localytics/android/ProfileHandler$ProfileOperation;->getOperationString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 170
    const-string v2, "attr"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 171
    instance-of v2, p3, [Ljava/lang/Object;

    if-eqz v2, :cond_3

    .line 173
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 174
    check-cast p3, [Ljava/lang/Object;

    check-cast p3, [Ljava/lang/Object;

    array-length v3, p3

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, p3, v0

    .line 176
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 174
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 178
    :cond_0
    const-string v0, "value"

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 184
    :cond_1
    :goto_1
    const/16 v0, 0x12d

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v3

    const/4 v1, 0x1

    aput-object p4, v2, v1

    const/4 v1, 0x2

    iget-object v3, p0, Lcom/localytics/android/ProfileHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v3}, Lcom/localytics/android/LocalyticsDao;->getCustomerIdInMemory()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-virtual {p0, v0, v2}, Lcom/localytics/android/ProfileHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/localytics/android/ProfileHandler;->queueMessage(Landroid/os/Message;)Z

    .line 191
    :cond_2
    :goto_2
    return-void

    .line 180
    :cond_3
    if-eqz p3, :cond_1

    .line 182
    const-string v0, "value"

    invoke-virtual {v1, v0, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 186
    :catch_0
    move-exception v0

    .line 188
    const-string v1, "Caught JSON exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2
.end method


# virtual methods
.method protected _deleteUploadedData(I)V
    .locals 4

    .prologue
    .line 78
    iget-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "changes"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "_id <= "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/localytics/android/BaseProvider;->remove(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 79
    return-void
.end method

.method protected _getDataToUpload()Ljava/util/TreeMap;
    .locals 10
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

    .line 115
    new-instance v6, Ljava/util/TreeMap;

    invoke-direct {v6}, Ljava/util/TreeMap;-><init>()V

    .line 119
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "changes"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-string v5, "_id ASC"

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v0

    move-object v1, v7

    .line 122
    :goto_0
    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-virtual {v6}, Ljava/util/TreeMap;->size()I

    move-result v2

    int-to-double v2, v2

    const-wide/high16 v4, 0x4049000000000000L    # 50.0

    cmpg-double v2, v2, v4

    if-gez v2, :cond_2

    .line 124
    const-string v2, "_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 125
    const-string v2, "change"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 126
    const-string v2, "customer_id"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 127
    const-string v2, "scope"

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 128
    if-nez v1, :cond_0

    move-object v7, v2

    move-object v1, v3

    .line 134
    :cond_0
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-virtual {v7, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 136
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v8, 0x3

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object v3, v8, v9

    const/4 v3, 0x1

    aput-object v2, v8, v3

    const/4 v2, 0x2

    aput-object v5, v8, v2

    invoke-virtual {v6, v4, v8}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 146
    :catchall_0
    move-exception v1

    :goto_1
    if-eqz v0, :cond_1

    .line 148
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_1
    move-object v0, v6

    .line 149
    :goto_2
    return-object v0

    .line 146
    :cond_2
    if-eqz v0, :cond_3

    .line 148
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_3
    move-object v0, v6

    .line 149
    goto :goto_2

    .line 146
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

    .line 90
    .line 94
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "changes"

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

    .line 95
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToLast()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 97
    const-string v0, "_id"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    .line 102
    :goto_0
    if-eqz v1, :cond_0

    .line 104
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 105
    :cond_0
    :goto_1
    return v0

    .line 102
    :catchall_0
    move-exception v0

    move-object v0, v7

    :goto_2
    if-eqz v0, :cond_1

    .line 104
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_1
    move v0, v6

    .line 105
    goto :goto_1

    .line 102
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
    .line 71
    new-instance v0, Lcom/localytics/android/ProfileProvider;

    iget-object v1, p0, Lcom/localytics/android/ProfileHandler;->siloName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/localytics/android/ProfileHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, v1, v2}, Lcom/localytics/android/ProfileProvider;-><init>(Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    iput-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    .line 72
    iget-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    invoke-virtual {v0}, Lcom/localytics/android/BaseProvider;->vacuumIfNecessary()V

    .line 73
    return-void
.end method

.method protected _onUploadCompleted(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    invoke-virtual {v0}, Lcom/localytics/android/BaseProvider;->vacuumIfNecessary()V

    .line 85
    return-void
.end method

.method addProfileAttributesToSet(Ljava/lang/String;[JLjava/lang/String;)V
    .locals 2

    .prologue
    .line 230
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETADD:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertToObjectArray([J)[Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 231
    return-void
.end method

.method addProfileAttributesToSet(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 235
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETADD:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 236
    return-void
.end method

.method addProfileAttributesToSet(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 240
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETADD:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertDateToString(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 241
    return-void
.end method

.method deleteProfileAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 225
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->DELETE:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    const/4 v1, 0x0

    invoke-direct {p0, v0, p1, v1, p2}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 226
    return-void
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
    .line 159
    new-instance v0, Lcom/localytics/android/ProfileUploadHandler;

    iget-object v1, p0, Lcom/localytics/android/ProfileHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/localytics/android/ProfileUploadHandler;-><init>(Lcom/localytics/android/BaseHandler;Ljava/util/TreeMap;Ljava/lang/String;Lcom/localytics/android/LocalyticsDao;)V

    return-object v0
.end method

.method protected handleMessageExtended(Landroid/os/Message;)V
    .locals 5

    .prologue
    .line 40
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 63
    invoke-super {p0, p1}, Lcom/localytics/android/BaseHandler;->handleMessageExtended(Landroid/os/Message;)V

    .line 67
    :goto_0
    return-void

    .line 44
    :pswitch_0
    const-string v0, "Profile handler received MESSAGE_SET_PROFILE_ATTRIBUTE"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->d(Ljava/lang/String;)I

    .line 46
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    check-cast v0, [Ljava/lang/Object;

    .line 47
    const/4 v1, 0x0

    aget-object v1, v0, v1

    check-cast v1, Ljava/lang/String;

    .line 48
    const/4 v2, 0x1

    aget-object v2, v0, v2

    check-cast v2, Ljava/lang/String;

    .line 49
    const/4 v3, 0x2

    aget-object v0, v0, v3

    check-cast v0, Ljava/lang/String;

    .line 51
    iget-object v3, p0, Lcom/localytics/android/ProfileHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    new-instance v4, Lcom/localytics/android/ProfileHandler$1;

    invoke-direct {v4, p0, v1, v2, v0}, Lcom/localytics/android/ProfileHandler$1;-><init>(Lcom/localytics/android/ProfileHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/localytics/android/BaseProvider;->runBatchTransaction(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 40
    :pswitch_data_0
    .packed-switch 0x12d
        :pswitch_0
    .end packed-switch
.end method

.method incrementProfileAttribute(Ljava/lang/String;JLjava/lang/String;)V
    .locals 2

    .prologue
    .line 260
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->INCREMENT:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p4}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 261
    return-void
.end method

.method removeProfileAttributesFromSet(Ljava/lang/String;[JLjava/lang/String;)V
    .locals 2

    .prologue
    .line 245
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETREMOVE:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertToObjectArray([J)[Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 246
    return-void
.end method

.method removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 250
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETREMOVE:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 251
    return-void
.end method

.method removeProfileAttributesFromSet(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 255
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->SETREMOVE:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertDateToString(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 256
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;JLjava/lang/String;)V
    .locals 2

    .prologue
    .line 195
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p4}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 205
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 206
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 215
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertDateToString(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 216
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;[JLjava/lang/String;)V
    .locals 2

    .prologue
    .line 200
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertToObjectArray([J)[Ljava/lang/Long;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 201
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 210
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 211
    return-void
.end method

.method setProfileAttribute(Ljava/lang/String;[Ljava/util/Date;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 220
    sget-object v0, Lcom/localytics/android/ProfileHandler$ProfileOperation;->ASSIGN:Lcom/localytics/android/ProfileHandler$ProfileOperation;

    invoke-static {p2}, Lcom/localytics/android/ProfileHandler;->convertDateToString(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1, p3}, Lcom/localytics/android/ProfileHandler;->saveAttributeChange(Lcom/localytics/android/ProfileHandler$ProfileOperation;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V

    .line 221
    return-void
.end method
