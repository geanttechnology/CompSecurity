.class public final Lcom/google/android/gms/internal/cd;
.super Lcom/google/android/gms/internal/cr;


# instance fields
.field final a:Landroid/app/Activity;

.field b:Lcom/google/android/gms/internal/cj;

.field c:Lcom/google/android/gms/internal/ew;

.field d:Lcom/google/android/gms/internal/cm;

.field e:Landroid/widget/FrameLayout;

.field f:Landroid/webkit/WebChromeClient$CustomViewCallback;

.field g:Landroid/widget/RelativeLayout;

.field private h:Lcom/google/android/gms/internal/bm;

.field private i:Lcom/google/android/gms/internal/cg;

.field private j:Z

.field private k:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/internal/cr;-><init>()V

    iput-boolean v0, p0, Lcom/google/android/gms/internal/cd;->j:Z

    iput-boolean v0, p0, Lcom/google/android/gms/internal/cd;->k:Z

    iput-object p1, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    return-void
.end method

.method static a(IIII)Landroid/widget/RelativeLayout$LayoutParams;
    .locals 2

    const/4 v1, 0x0

    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, p2, p3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, p0, p1, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    const/16 v1, 0xa

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/bm;)V
    .locals 3

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "com.google.android.gms.ads.AdActivity"

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    const-string v1, "com.google.android.gms.ads.internal.overlay.useClientJar"

    iget-object v2, p1, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/cu;->e:Z

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/bm;->a(Landroid/content/Intent;Lcom/google/android/gms/internal/bm;)V

    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private a(Z)V
    .locals 4

    const/4 v3, -0x2

    if-eqz p1, :cond_0

    const/16 v0, 0x32

    :goto_0
    new-instance v1, Lcom/google/android/gms/internal/cm;

    iget-object v2, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-direct {v1, v2, v0}, Lcom/google/android/gms/internal/cm;-><init>(Landroid/app/Activity;I)V

    iput-object v1, p0, Lcom/google/android/gms/internal/cd;->d:Lcom/google/android/gms/internal/cm;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    const/16 v0, 0xa

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    if-eqz p1, :cond_1

    const/16 v0, 0xb

    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->d:Lcom/google/android/gms/internal/cm;

    iget-object v2, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/bm;->h:Z

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/cm;->a(Z)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/google/android/gms/internal/cd;->d:Lcom/google/android/gms/internal/cm;

    invoke-virtual {v0, v2, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    :cond_0
    const/16 v0, 0x20

    goto :goto_0

    :cond_1
    const/16 v0, 0x9

    goto :goto_1
.end method

.method private b(Z)V
    .locals 12

    const/high16 v5, 0x1000000

    const/16 v1, 0x400

    const/4 v11, -0x1

    const/4 v2, 0x1

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0, v2}, Landroid/app/Activity;->requestWindowFeature(I)Z

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget v1, v1, Lcom/google/android/gms/internal/bm;->k:I

    invoke-virtual {p0, v1}, Lcom/google/android/gms/internal/cd;->a(I)V

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v1, v3, :cond_0

    const-string v1, "Enabling hardware acceleration on the AdActivity window."

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v5}, Landroid/view/Window;->setFlags(II)V

    :cond_0
    new-instance v0, Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iget-object v0, v0, Lcom/google/android/gms/internal/ew;->a:Lcom/google/android/gms/internal/ez;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ez;->a()Z

    move-result v3

    if-eqz p1, :cond_4

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v1, v1, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/ew;->c()Lcom/google/android/gms/internal/x;

    move-result-object v1

    iget-object v5, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v5, v5, Lcom/google/android/gms/internal/bm;->n:Lcom/google/android/gms/internal/cu;

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/ew;->a(Landroid/content/Context;Lcom/google/android/gms/internal/x;ZZLcom/google/android/gms/internal/jg;Lcom/google/android/gms/internal/cu;)Lcom/google/android/gms/internal/ew;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v5, v0, Lcom/google/android/gms/internal/ew;->a:Lcom/google/android/gms/internal/ez;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v8, v0, Lcom/google/android/gms/internal/bm;->f:Lcom/google/android/gms/internal/u;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v9, v0, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    move-object v6, v4

    move-object v7, v4

    move v10, v2

    invoke-virtual/range {v5 .. v10}, Lcom/google/android/gms/internal/ez;->a(Lcom/google/android/gms/internal/kq;Lcom/google/android/gms/internal/ci;Lcom/google/android/gms/internal/u;Lcom/google/android/gms/internal/cn;Z)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v0, v0, Lcom/google/android/gms/internal/ew;->a:Lcom/google/android/gms/internal/ez;

    new-instance v1, Lcom/google/android/gms/internal/ce;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/ce;-><init>(Lcom/google/android/gms/internal/cd;)V

    iput-object v1, v0, Lcom/google/android/gms/internal/ez;->f:Lcom/google/android/gms/internal/fb;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v1, v1, Lcom/google/android/gms/internal/bm;->m:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/ew;->loadUrl(Ljava/lang/String;)V

    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v1, v0, Lcom/google/android/gms/internal/ew;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-object p0, v0, Lcom/google/android/gms/internal/ew;->e:Lcom/google/android/gms/internal/cd;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v0, v1, v11, v11}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;II)V

    if-nez p1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ew;->a()V

    :cond_1
    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/cd;->a(Z)V

    return-void

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v5, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v6, v0, Lcom/google/android/gms/internal/bm;->g:Ljava/lang/String;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v7, v0, Lcom/google/android/gms/internal/bm;->i:Ljava/lang/String;

    const-string v8, "text/html"

    const-string v9, "UTF-8"

    move-object v10, v4

    invoke-virtual/range {v5 .. v10}, Lcom/google/android/gms/internal/ew;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    new-instance v0, Lcom/google/android/gms/internal/cf;

    const-string v1, "No URL or HTML to display in ad overlay."

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cf;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    iput-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/ew;->setContext(Landroid/content/Context;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private i()V
    .locals 4

    const/4 v2, 0x1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/cd;->k:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-boolean v2, p0, Lcom/google/android/gms/internal/cd;->k:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1, v2}, Ljava/util/HashMap;-><init>(I)V

    const-string v2, "version"

    iget-object v3, v0, Lcom/google/android/gms/internal/ew;->d:Lcom/google/android/gms/internal/cu;

    iget-object v3, v3, Lcom/google/android/gms/internal/cu;->b:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v2, "onhide"

    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/internal/ew;->a(Ljava/lang/String;Ljava/util/Map;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->removeView(Landroid/view/View;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/ew;->a(Z)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    iget-object v0, v0, Lcom/google/android/gms/internal/cg;->c:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v2, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    iget v2, v2, Lcom/google/android/gms/internal/cg;->a:I

    iget-object v3, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    iget-object v3, v3, Lcom/google/android/gms/internal/cg;->b:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ci;->o()V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget v0, v0, Lcom/google/android/gms/internal/bm;->k:I

    invoke-virtual {p0, v0}, Lcom/google/android/gms/internal/cd;->a(I)V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->e:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->e:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    iput-object v2, p0, Lcom/google/android/gms/internal/cd;->e:Landroid/widget/FrameLayout;

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->f:Landroid/webkit/WebChromeClient$CustomViewCallback;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->f:Landroid/webkit/WebChromeClient$CustomViewCallback;

    invoke-interface {v0}, Landroid/webkit/WebChromeClient$CustomViewCallback;->onCustomViewHidden()V

    iput-object v2, p0, Lcom/google/android/gms/internal/cd;->f:Landroid/webkit/WebChromeClient$CustomViewCallback;

    :cond_2
    return-void
.end method

.method public final a(I)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    return-void
.end method

.method public final a(Landroid/os/Bundle;)V
    .locals 3

    const/4 v2, 0x1

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    const-string v1, "com.google.android.gms.ads.internal.overlay.hasResumed"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    :cond_0
    iput-boolean v0, p0, Lcom/google/android/gms/internal/cd;->j:Z

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/bm;->a(Landroid/content/Intent;)Lcom/google/android/gms/internal/bm;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    if-nez v0, :cond_2

    new-instance v0, Lcom/google/android/gms/internal/cf;

    const-string v1, "Could not get info for ad overlay."

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cf;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Lcom/google/android/gms/internal/cf; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/cf;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    :cond_1
    :goto_0
    return-void

    :cond_2
    if-nez p1, :cond_4

    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->d:Lcom/google/android/gms/internal/ci;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ci;->p()V

    :cond_3
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget v0, v0, Lcom/google/android/gms/internal/bm;->l:I

    if-eq v0, v2, :cond_4

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v0, v0, Lcom/google/android/gms/internal/bm;->c:Lcom/google/android/gms/internal/kq;

    invoke-interface {v0}, Lcom/google/android/gms/internal/kq;->r()V

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget v0, v0, Lcom/google/android/gms/internal/bm;->l:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Lcom/google/android/gms/internal/cf;

    const-string v1, "Could not determine ad overlay type."

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cf;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/cd;->b(Z)V

    goto :goto_0

    :pswitch_1
    new-instance v0, Lcom/google/android/gms/internal/cg;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v1, v1, Lcom/google/android/gms/internal/bm;->e:Lcom/google/android/gms/internal/ew;

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cg;-><init>(Lcom/google/android/gms/internal/ew;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/cd;->b(Z)V

    goto :goto_0

    :pswitch_2
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/cd;->b(Z)V

    goto :goto_0

    :pswitch_3
    iget-boolean v0, p0, Lcom/google/android/gms/internal/cd;->j:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0

    :cond_5
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v1, v1, Lcom/google/android/gms/internal/bm;->b:Lcom/google/android/gms/internal/bj;

    iget-object v2, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget-object v2, v2, Lcom/google/android/gms/internal/bm;->j:Lcom/google/android/gms/internal/cn;

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/ca;->a(Landroid/content/Context;Lcom/google/android/gms/internal/bj;Lcom/google/android/gms/internal/cn;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V
    :try_end_1
    .catch Lcom/google/android/gms/internal/cf; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final b()V
    .locals 0

    return-void
.end method

.method public final b(Landroid/os/Bundle;)V
    .locals 2

    const-string v0, "com.google.android.gms.ads.internal.overlay.hasResumed"

    iget-boolean v1, p0, Lcom/google/android/gms/internal/cd;->j:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    return-void
.end method

.method public final c()V
    .locals 0

    return-void
.end method

.method public final d()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->h:Lcom/google/android/gms/internal/bm;

    iget v0, v0, Lcom/google/android/gms/internal/bm;->l:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/cd;->j:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-static {v0}, Lcom/google/android/gms/internal/ej;->b(Landroid/webkit/WebView;)V

    :cond_1
    return-void

    :cond_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/cd;->j:Z

    goto :goto_0
.end method

.method public final e()V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    iget-object v0, v0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->pause()V

    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/cd;->a()V

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->i:Lcom/google/android/gms/internal/cg;

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-static {v0}, Lcom/google/android/gms/internal/ej;->a(Landroid/webkit/WebView;)V

    :cond_2
    invoke-direct {p0}, Lcom/google/android/gms/internal/cd;->i()V

    return-void
.end method

.method public final f()V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/cd;->i()V

    return-void
.end method

.method public final g()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    iget-object v1, v0, Lcom/google/android/gms/internal/cj;->c:Lcom/google/android/gms/internal/ck;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/google/android/gms/internal/ck;->b:Z

    sget-object v2, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    iget-object v1, v1, Lcom/google/android/gms/internal/ck;->a:Ljava/lang/Runnable;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    iget-object v0, v0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->stopPlayback()V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->removeView(Landroid/view/View;)V

    :cond_1
    invoke-direct {p0}, Lcom/google/android/gms/internal/cd;->i()V

    return-void
.end method

.method public final h()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/google/android/gms/internal/cd;->d:Lcom/google/android/gms/internal/cm;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->removeView(Landroid/view/View;)V

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/cd;->a(Z)V

    return-void
.end method
