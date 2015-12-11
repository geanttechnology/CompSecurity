.class abstract Lcom/amazon/android/webkit/android/AndroidWebViewReflection;
.super Ljava/lang/Object;
.source "AndroidWebViewReflection.java"


# instance fields
.field protected final webView:Landroid/webkit/WebView;


# direct methods
.method protected constructor <init>(Landroid/webkit/WebView;)V
    .locals 0
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->webView:Landroid/webkit/WebView;

    .line 35
    return-void
.end method

.method public static create(Landroid/webkit/WebView;)Lcom/amazon/android/webkit/android/AndroidWebViewReflection;
    .locals 2
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 23
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 24
    const/4 v0, 0x0

    .line 29
    :goto_0
    return-object v0

    .line 26
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-le v0, v1, :cond_1

    .line 27
    new-instance v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;

    invoke-direct {v0, p0}, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;-><init>(Landroid/webkit/WebView;)V

    goto :goto_0

    .line 29
    :cond_1
    new-instance v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;

    invoke-direct {v0, p0}, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;-><init>(Landroid/webkit/WebView;)V

    goto :goto_0
.end method


# virtual methods
.method public abstract getTouchIconUrl()Ljava/lang/String;
.end method

.method public abstract getVerticalScrollOffset()I
.end method

.method public abstract setFindIsUp(Z)V
.end method

.method public abstract setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
.end method

.method public abstract setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V
.end method
