.class Lcom/adobe/mobile/WearableDataRequest$Post;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "WearableDataRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Post"
.end annotation


# static fields
.field private static final _userAgentMutex:Ljava/lang/Object;

.field protected static final logPrefix:Ljava/lang/String; = "Wearable POST Request Forward"

.field private static userAgent:Ljava/lang/String;


# instance fields
.field protected body:Ljava/lang/String;

.field protected url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 173
    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    .line 174
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->_userAgentMutex:Ljava/lang/Object;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 1
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 119
    const-string v0, "Timeout"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    .line 120
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    .line 121
    const-string v0, "Body"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    .line 122
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    .line 123
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "body"    # Ljava/lang/String;
    .param p3, "timeOut"    # I

    .prologue
    .line 113
    invoke-direct {p0, p3}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 114
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    .line 115
    iput-object p2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    .line 116
    return-void
.end method

.method protected static getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 153
    if-nez p0, :cond_1

    .line 170
    :cond_0
    :goto_0
    return-object v3

    .line 155
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 156
    .local v2, "resources":Landroid/content/res/Resources;
    if-eqz v2, :cond_0

    .line 160
    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    .line 161
    .local v0, "configuration":Landroid/content/res/Configuration;
    if-eqz v0, :cond_0

    .line 165
    iget-object v1, v0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 166
    .local v1, "locale":Ljava/util/Locale;
    if-eqz v1, :cond_0

    .line 170
    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x5f

    const/16 v5, 0x2d

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method protected static getDefaultUserAgent(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 176
    sget-object v1, Lcom/adobe/mobile/WearableDataRequest$Post;->_userAgentMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 177
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 178
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Mozilla/5.0 (Linux; U; Android "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "; "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 179
    invoke-static {p0}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "; "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " Build/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build;->ID:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    .line 182
    :cond_0
    sget-object v0, Lcom/adobe/mobile/WearableDataRequest$Post;->userAgent:Ljava/lang/String;

    monitor-exit v1

    return-object v0

    .line 183
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method protected getDataMap()Lcom/google/android/gms/wearable/DataMap;
    .locals 3

    .prologue
    .line 126
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 127
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const-string v1, "Type"

    const-string v2, "POST"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v1, "Timeout"

    iget v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putInt(Ljava/lang/String;I)V

    .line 131
    const-string v1, "Body"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    return-object v0
.end method

.method protected getURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Lcom/google/android/gms/wearable/DataMap;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 136
    new-instance v1, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v1}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 139
    .local v1, "responseDataMap":Lcom/google/android/gms/wearable/DataMap;
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 141
    .local v0, "headers":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "Accept-Language"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultAcceptLanguage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    const-string v3, "User-Agent"

    invoke-static {p1}, Lcom/adobe/mobile/WearableDataRequest$Post;->getDefaultUserAgent(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    iget-object v3, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->url:Ljava/lang/String;

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->body:Ljava/lang/String;

    iget v5, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->timeOut:I

    const-string v6, "Wearable POST Request Forward"

    invoke-static {v3, v4, v0, v5, v6}, Lcom/adobe/mobile/RequestHandler;->sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Z

    move-result v2

    .line 146
    .local v2, "result":Z
    const-string v3, "Result"

    invoke-virtual {v1, v3, v2}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 147
    const-string v3, "ID"

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$Post;->uuid:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    const-string v3, "Type"

    const-string v4, "POST"

    invoke-virtual {v1, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    return-object v1
.end method
