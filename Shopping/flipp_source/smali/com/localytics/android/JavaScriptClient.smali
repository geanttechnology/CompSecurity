.class final Lcom/localytics/android/JavaScriptClient;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final mCallbacks:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/util/SparseArray;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/localytics/android/JavaScriptClient;->mCallbacks:Landroid/util/SparseArray;

    .line 26
    return-void
.end method

.method static synthetic access$000(Lcom/localytics/android/JavaScriptClient;I[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private invoke(I[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 83
    const/4 v1, 0x0

    .line 85
    iget-object v0, p0, Lcom/localytics/android/JavaScriptClient;->mCallbacks:Landroid/util/SparseArray;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/localytics/android/JavaScriptClient;->mCallbacks:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/localytics/android/MarketingCallable;

    .line 88
    if-eqz v0, :cond_0

    .line 90
    invoke-virtual {v0, p2}, Lcom/localytics/android/MarketingCallable;->call([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 94
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method final getAttributes()Ljava/lang/String;
    .locals 2

    .prologue
    .line 78
    const/4 v0, 0x7

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method final getCallbacks()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Lcom/localytics/android/MarketingCallable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/localytics/android/JavaScriptClient;->mCallbacks:Landroid/util/SparseArray;

    return-object v0
.end method

.method final getCustomDimensions()Ljava/lang/String;
    .locals 2

    .prologue
    .line 73
    const/4 v0, 0x6

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method final getIdentifiers()Ljava/lang/String;
    .locals 2

    .prologue
    .line 68
    const/4 v0, 0x5

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method final getJsGlueCode()Ljava/lang/String;
    .locals 4

    .prologue
    .line 35
    const-string v0, "javascript:(function() {  var localyticsScript = document.createElement(\'script\');  localyticsScript.type = \'text/javascript\';  localyticsScript.text = \'  localytics.identifers = %s;  localytics.customDimensions = %s;  localytics.attributes = %s;  localytics.libraryVersion = \"%s\";  localytics.tagEvent = function(event, attributes, customerValueIncrease) {     localytics.nativeTagEvent(event, JSON.stringify(attributes), JSON.stringify(customerValueIncrease));  };  localytics.setCustomDimension = function(number, value) {     if (number != null && value != null)        localytics.nativeSetCustomDimension(number, value);  };  window.open = function(url) {     if (url != null)        localytics.navigate(url);  };  localytics.close = function() {     localytics.nativeClose();  };\';  document.getElementsByTagName(\'body\')[0].appendChild(localyticsScript);})()"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/localytics/android/JavaScriptClient;->getIdentifiers()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0}, Lcom/localytics/android/JavaScriptClient;->getCustomDimensions()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-virtual {p0}, Lcom/localytics/android/JavaScriptClient;->getAttributes()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    invoke-static {}, Lcom/localytics/android/Localytics;->getLibraryVersion()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final nativeClose()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 120
    const-string v0, "[JavaScriptClient]: nativeClose is being called"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 121
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/localytics/android/JavaScriptClient$1;

    invoke-direct {v1, p0}, Lcom/localytics/android/JavaScriptClient$1;-><init>(Lcom/localytics/android/JavaScriptClient;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 128
    return-void
.end method

.method public final nativeSetCustomDimension(JLjava/lang/String;)V
    .locals 5
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 107
    const-string v0, "[JavaScriptClient]: nativeSetCustomDimension is being called"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 108
    const/16 v0, 0x8

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    long-to-int v3, p1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    return-void
.end method

.method public final nativeTagEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    const/4 v2, 0x3

    .line 100
    const-string v0, "[JavaScriptClient]: nativeTagEvent is being called"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 101
    new-array v0, v2, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 v1, 0x1

    aput-object p2, v0, v1

    const/4 v1, 0x2

    aput-object p3, v0, v1

    invoke-direct {p0, v2, v0}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    return-void
.end method

.method public final navigate(Ljava/lang/String;)V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 114
    const/16 v0, 0xf

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/localytics/android/JavaScriptClient;->invoke(I[Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    return-void
.end method
