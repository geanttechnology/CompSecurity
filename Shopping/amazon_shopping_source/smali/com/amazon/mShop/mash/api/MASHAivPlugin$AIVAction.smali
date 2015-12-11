.class abstract enum Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
.super Ljava/lang/Enum;
.source "MASHAivPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/api/MASHAivPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x440a
    name = "AIVAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

.field private static final ASIN_HOLDER:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

.field public static final enum IS_PLAYBACK_SUSTAINABLE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

.field public static final enum START_PLAYBACK:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

.field public static final enum START_TRAILER:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

.field public static final enum WHISPER_CACHE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;


# instance fields
.field private final mApiName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 63
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$1;

    const-string/jumbo v1, "IS_PLAYBACK_SUSTAINABLE"

    const-string/jumbo v2, "aiv.IsPlaybackSustainable"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$1;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->IS_PLAYBACK_SUSTAINABLE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 69
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$2;

    const-string/jumbo v1, "START_PLAYBACK"

    const-string/jumbo v2, "aiv.StartPlayback"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$2;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->START_PLAYBACK:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 103
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$3;

    const-string/jumbo v1, "START_TRAILER"

    const-string/jumbo v2, "aiv.StartTrailer"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$3;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->START_TRAILER:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 128
    new-instance v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$4;

    const-string/jumbo v1, "WHISPER_CACHE"

    const-string/jumbo v2, "aiv.WhisperCache"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction$4;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->WHISPER_CACHE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 62
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    sget-object v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->IS_PLAYBACK_SUSTAINABLE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->START_PLAYBACK:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->START_TRAILER:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->WHISPER_CACHE:Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->$VALUES:[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    .line 156
    invoke-static {}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->getInstance()Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->ASIN_HOLDER:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "ApiName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 158
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 159
    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->mApiName:Ljava/lang/String;

    .line 160
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Lcom/amazon/mShop/mash/api/MASHAivPlugin$1;

    .prologue
    .line 62
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Landroid/app/Activity;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Landroid/app/Activity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 62
    invoke-static {p0, p1}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->redirectToInstallCompanionApp(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static actionFromAPIName(Ljava/lang/String;)Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    .locals 5
    .param p0, "ApiName"    # Ljava/lang/String;

    .prologue
    .line 167
    invoke-static {}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->values()[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    move-result-object v1

    .local v1, "arr$":[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v0, v1, v2

    .line 168
    .local v0, "action":Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    invoke-virtual {v0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->getApiName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 172
    .end local v0    # "action":Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    :goto_1
    return-object v0

    .line 167
    .restart local v0    # "action":Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 172
    .end local v0    # "action":Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private static redirectToInstallCompanionApp(Landroid/app/Activity;Ljava/lang/String;)Z
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 191
    invoke-static {p0}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVCompanionAppInstalled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 192
    sget-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->ASIN_HOLDER:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->reset()V

    .line 193
    const/4 v0, 0x0

    .line 199
    :goto_0
    return v0

    .line 196
    :cond_0
    sget-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->ASIN_HOLDER:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->setAsin(Ljava/lang/String;)V

    .line 198
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/mash/api/MASHAivPlugin$CompanionAppMessageRunnable;-><init>(Landroid/app/Activity;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 199
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 62
    const-class v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->$VALUES:[Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    invoke-virtual {v0}, [Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;

    return-object v0
.end method


# virtual methods
.method public abstract execute(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;Lorg/apache/cordova/CordovaPlugin;)Z
.end method

.method protected getApiName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHAivPlugin$AIVAction;->mApiName:Ljava/lang/String;

    return-object v0
.end method

.method public onActivityResult(Lorg/apache/cordova/CallbackContext;IILandroid/content/Intent;)V
    .locals 0
    .param p1, "callbackContext"    # Lorg/apache/cordova/CallbackContext;
    .param p2, "requestCode"    # I
    .param p3, "resultCode"    # I
    .param p4, "data"    # Landroid/content/Intent;

    .prologue
    .line 179
    return-void
.end method
