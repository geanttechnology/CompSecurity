.class final Lcn/jpush/android/api/r;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field final synthetic a:Lcn/jpush/android/data/d;

.field final synthetic b:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v0, 0x4

    new-array v5, v0, [Ljava/lang/String;

    const-string v4, "\u00077vu"

    const/4 v0, -0x1

    move-object v6, v5

    move-object v7, v5

    move v5, v1

    :goto_0
    invoke-virtual {v4}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    array-length v8, v4

    if-gt v8, v2, :cond_2

    move v9, v1

    :cond_0
    move-object v10, v4

    move v11, v9

    move v14, v8

    move-object v8, v4

    move v4, v14

    :goto_1
    aget-char v13, v8, v9

    rem-int/lit8 v12, v11, 0x5

    packed-switch v12, :pswitch_data_0

    const/16 v12, 0x1a

    :goto_2
    xor-int/2addr v12, v13

    int-to-char v12, v12

    aput-char v12, v8, v9

    add-int/lit8 v9, v11, 0x1

    if-nez v4, :cond_1

    move-object v8, v10

    move v11, v9

    move v9, v4

    goto :goto_1

    :cond_1
    move v8, v4

    move-object v4, v10

    :goto_3
    if-gt v8, v9, :cond_0

    new-instance v8, Ljava/lang/String;

    invoke-direct {v8, v4}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v8}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    packed-switch v0, :pswitch_data_1

    aput-object v4, v6, v5

    const-string v0, ":\u0017D(\""

    move-object v4, v0

    move v5, v2

    move-object v6, v7

    move v0, v1

    goto :goto_0

    :pswitch_0
    aput-object v4, v6, v5

    const-string v0, "\u0018*lau\u0018"

    move-object v4, v0

    move v5, v3

    move-object v6, v7

    move v0, v2

    goto :goto_0

    :pswitch_1
    aput-object v4, v6, v5

    const/4 v4, 0x3

    const-string v0, "%\u0013wvr8&`"

    move v5, v4

    move-object v6, v7

    move-object v4, v0

    move v0, v3

    goto :goto_0

    :pswitch_2
    aput-object v4, v6, v5

    sput-object v7, Lcn/jpush/android/api/r;->z:[Ljava/lang/String;

    return-void

    :pswitch_3
    const/16 v12, 0x6f

    goto :goto_2

    :pswitch_4
    const/16 v12, 0x43

    goto :goto_2

    :pswitch_5
    move v12, v3

    goto :goto_2

    :pswitch_6
    const/4 v12, 0x5

    goto :goto_2

    :cond_2
    move v9, v1

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method constructor <init>(Lcn/jpush/android/data/d;Landroid/content/Context;)V
    .locals 0

    iput-object p1, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    iput-object p2, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 9

    const/4 v8, 0x2

    const/4 v7, 0x0

    const/4 v2, 0x1

    iget-object v0, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    instance-of v0, v0, Lcn/jpush/android/data/s;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    invoke-virtual {v0}, Lcn/jpush/android/data/d;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    check-cast v0, Lcn/jpush/android/data/s;

    iget-object v6, v0, Lcn/jpush/android/data/s;->a:Ljava/lang/String;

    iget-object v0, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    sget-object v1, Lcn/jpush/android/api/r;->z:[Ljava/lang/String;

    aget-object v1, v1, v8

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    new-instance v4, Landroid/webkit/WebView;

    iget-object v0, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    invoke-direct {v4, v0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    new-instance v5, Landroid/widget/ImageButton;

    iget-object v0, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    invoke-direct {v5, v0}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    iget-object v0, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    invoke-static {v0, v3, v4, v5}, Lcn/jpush/android/api/q;->a(Landroid/content/Context;Landroid/view/WindowManager;Landroid/webkit/WebView;Landroid/widget/ImageButton;)V

    invoke-virtual {v4, v7}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    invoke-virtual {v4, v7}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    invoke-virtual {v4, v2}, Landroid/webkit/WebView;->setScrollbarFadingEnabled(Z)V

    const/high16 v0, 0x2000000

    invoke-virtual {v4, v0}, Landroid/webkit/WebView;->setScrollBarStyle(I)V

    invoke-virtual {v4}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    sget-object v1, Lcn/jpush/android/api/r;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    invoke-virtual {v0, v8}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    new-instance v0, Lcn/jpush/android/api/t;

    iget-object v1, p0, Lcn/jpush/android/api/r;->b:Landroid/content/Context;

    iget-object v2, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    invoke-direct/range {v0 .. v5}, Lcn/jpush/android/api/t;-><init>(Landroid/content/Context;Lcn/jpush/android/data/d;Landroid/view/WindowManager;Landroid/webkit/WebView;Landroid/widget/ImageButton;)V

    sget-object v1, Lcn/jpush/android/api/r;->z:[Ljava/lang/String;

    const/4 v2, 0x3

    aget-object v1, v1, v2

    invoke-virtual {v4, v0, v1}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcn/jpush/android/ui/f;

    iget-object v1, p0, Lcn/jpush/android/api/r;->a:Lcn/jpush/android/data/d;

    invoke-direct {v0, v1}, Lcn/jpush/android/ui/f;-><init>(Lcn/jpush/android/data/d;)V

    invoke-virtual {v4, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/api/r;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    invoke-virtual {v6, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v4, v6}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    :cond_0
    new-instance v0, Lcn/jpush/android/api/s;

    invoke-direct {v0, p0, v3, v4, v5}, Lcn/jpush/android/api/s;-><init>(Lcn/jpush/android/api/r;Landroid/view/WindowManager;Landroid/webkit/WebView;Landroid/widget/ImageButton;)V

    invoke-virtual {v5, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :goto_0
    return-void

    :cond_1
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0
.end method
