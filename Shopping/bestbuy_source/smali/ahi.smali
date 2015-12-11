.class public Lahi;
.super Ltr;

# interfaces
.implements Laab;
.implements Labk;
.implements Lahh;
.implements Laho;
.implements Lvb;
.implements Lve;
.implements Lvg;
.implements Lvw;
.implements Lxh;
.implements Lxj;
.implements Lyd;
.implements Lzh;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private a:Lcom/google/android/gms/internal/av;

.field private final b:Lwd;

.field private final c:Lahk;

.field private final d:Lsk;

.field private final e:Lso;

.field private f:Z

.field private final g:Landroid/content/ComponentCallbacks;


# direct methods
.method constructor <init>(Lahk;Lwd;Lsk;)V
    .locals 2

    invoke-direct {p0}, Ltr;-><init>()V

    new-instance v0, Lahi$1;

    invoke-direct {v0, p0}, Lahi$1;-><init>(Lahi;)V

    iput-object v0, p0, Lahi;->g:Landroid/content/ComponentCallbacks;

    iput-object p1, p0, Lahi;->c:Lahk;

    iput-object p2, p0, Lahi;->b:Lwd;

    if-eqz p3, :cond_0

    :goto_0
    iput-object p3, p0, Lahi;->d:Lsk;

    new-instance v0, Lso;

    invoke-direct {v0}, Lso;-><init>()V

    iput-object v0, p0, Lahi;->e:Lso;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    invoke-static {v0}, Labq;->b(Landroid/content/Context;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    invoke-static {v0, v1}, Labi;->a(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V

    invoke-direct {p0}, Lahi;->w()V

    return-void

    :cond_0
    new-instance p3, Lsk;

    invoke-direct {p3, p0}, Lsk;-><init>(Lahi;)V

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lwd;Lcom/google/android/gms/internal/gs;)V
    .locals 2

    new-instance v0, Lahk;

    invoke-direct {v0, p1, p2, p3, p5}, Lahk;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lcom/google/android/gms/internal/gs;)V

    const/4 v1, 0x0

    invoke-direct {p0, v0, p4, v1}, Lahi;-><init>(Lahk;Lwd;Lsk;)V

    return-void
.end method

.method private A()V
    .locals 2

    const-string v0, "Ad opening."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    invoke-interface {v0}, Ltn;->d()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call AdListener.onAdOpened()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private B()V
    .locals 2

    const-string v0, "Ad finished loading."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    invoke-interface {v0}, Ltn;->c()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call AdListener.onAdLoaded()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private C()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->w:Lut;

    instance-of v0, v0, Luq;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->p:Luy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v1, v0, Lahk;->p:Luy;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->w:Lut;

    check-cast v0, Luq;

    invoke-interface {v1, v0}, Luy;->a(Luu;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private D()V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->w:Lut;

    instance-of v0, v0, Lur;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->q:Luz;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v1, v0, Lahk;->q:Luz;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->w:Lut;

    check-cast v0, Lur;

    invoke-interface {v1, v0}, Luz;->a(Luw;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call OnContentAdLoadedListener.onContentAdLoaded()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private E()V
    .locals 2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->destroy()V

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    const/4 v1, 0x0

    iput-object v1, v0, Lahk;->j:Labd;

    iget-object v0, p0, Lahi;->c:Lahk;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lahk;->y:Z

    :cond_1
    return-void
.end method

.method private a(Lcom/google/android/gms/internal/av;Landroid/os/Bundle;)Laak;
    .locals 14

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v5

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    :goto_0
    const/4 v1, 0x0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    new-array v0, v0, [I

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->a:Lahj;

    invoke-virtual {v1, v0}, Lahj;->getLocationOnScreen([I)V

    const/4 v1, 0x0

    aget v2, v0, v1

    const/4 v1, 0x1

    aget v3, v0, v1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getWidth()I

    move-result v4

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getHeight()I

    move-result v7

    const/4 v0, 0x0

    iget-object v8, p0, Lahi;->c:Lahk;

    iget-object v8, v8, Lahk;->a:Lahj;

    invoke-virtual {v8}, Lahj;->isShown()Z

    move-result v8

    if-eqz v8, :cond_0

    add-int v8, v2, v4

    if-lez v8, :cond_0

    add-int v8, v3, v7

    if-lez v8, :cond_0

    iget v8, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    if-gt v2, v8, :cond_0

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    if-gt v3, v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    new-instance v1, Landroid/os/Bundle;

    const/4 v8, 0x5

    invoke-direct {v1, v8}, Landroid/os/Bundle;-><init>(I)V

    const-string v8, "x"

    invoke-virtual {v1, v8, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v2, "y"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v2, "width"

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v2, "height"

    invoke-virtual {v1, v2, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string v2, "visible"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    :cond_1
    invoke-static {}, Labi;->d()Ljava/lang/String;

    move-result-object v7

    iget-object v0, p0, Lahi;->c:Lahk;

    new-instance v2, Labf;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->b:Ljava/lang/String;

    invoke-direct {v2, v7, v3}, Labf;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, v0, Lahk;->l:Labf;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    invoke-virtual {v0, p1}, Labf;->a(Lcom/google/android/gms/internal/av;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    invoke-static {v0, p0, v7}, Labi;->a(Landroid/content/Context;Labk;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v10

    new-instance v0, Laak;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v3, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v4, v2, Lahk;->b:Ljava/lang/String;

    sget-object v8, Labi;->a:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v9, v2, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v11, v2, Lahk;->s:Ljava/util/List;

    invoke-static {}, Labi;->j()Z

    move-result v13

    move-object v2, p1

    move-object/from16 v12, p2

    invoke-direct/range {v0 .. v13}, Laak;-><init>(Landroid/os/Bundle;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/gs;Landroid/os/Bundle;Ljava/util/List;Landroid/os/Bundle;Z)V

    return-object v0

    :catch_0
    move-exception v0

    const/4 v6, 0x0

    goto/16 :goto_0
.end method

.method static synthetic a(Lahi;)Lahk;
    .locals 1

    iget-object v0, p0, Lahi;->c:Lahk;

    return-object v0
.end method

.method private a(Lahl;)Lcom/google/android/gms/internal/gu;
    .locals 11

    const/4 v2, 0x0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v4, v3, Lahk;->d:Laea;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v5, v3, Lahk;->e:Lcom/google/android/gms/internal/gs;

    move v3, v2

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;ZZLaea;Lcom/google/android/gms/internal/gs;)Lcom/google/android/gms/internal/gu;

    move-result-object v9

    invoke-virtual {v9}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v5, 0x1

    move-object v1, p0

    move-object v3, p0

    move-object v4, p0

    move-object v6, p0

    move-object v7, p0

    move-object v8, p1

    invoke-virtual/range {v0 .. v8}, Lace;->a(Lahh;Lxh;Lvb;Lxj;ZLve;Lvg;Lahl;)V

    move-object v0, v9

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getNextView()Landroid/view/View;

    move-result-object v0

    instance-of v1, v0, Lcom/google/android/gms/internal/gu;

    if-eqz v1, :cond_2

    check-cast v0, Lcom/google/android/gms/internal/gu;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->i:Lcom/google/android/gms/internal/ay;

    invoke-virtual {v0, v1, v3}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;)V

    :cond_1
    :goto_1
    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v3

    move-object v4, p0

    move-object v5, p0

    move-object v6, p0

    move-object v7, p0

    move v8, v2

    move-object v9, p0

    move-object v10, p1

    invoke-virtual/range {v3 .. v10}, Lace;->a(Lahh;Lxh;Lvb;Lxj;ZLve;Lahl;)V

    goto :goto_0

    :cond_2
    if-eqz v0, :cond_3

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->a:Lahj;

    invoke-virtual {v1, v0}, Lahj;->removeView(Landroid/view/View;)V

    :cond_3
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v4, v3, Lahk;->d:Laea;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v5, v3, Lahk;->e:Lcom/google/android/gms/internal/gs;

    move v3, v2

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;ZZLaea;Lcom/google/android/gms/internal/gs;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v1, v1, Lcom/google/android/gms/internal/ay;->h:[Lcom/google/android/gms/internal/ay;

    if-nez v1, :cond_1

    invoke-direct {p0, v0}, Lahi;->b(Landroid/view/View;)V

    goto :goto_1
.end method

.method private a(I)V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Failed to load ad: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    invoke-interface {v0, p1}, Ltn;->a(I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call AdListener.onAdFailedToLoad()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private b(Landroid/view/View;)V
    .locals 2

    const/4 v1, -0x2

    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->a:Lahj;

    invoke-virtual {v1, p1, v0}, Lahj;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method

.method private b(Z)V
    .locals 6

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-nez v0, :cond_1

    const-string v0, "Ad state was null when trying to ping impression URLs."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "Pinging Impression URLs."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    invoke-virtual {v0}, Labf;->a()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->e:Ljava/util/List;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v2, v2, Labd;->e:Ljava/util/List;

    invoke-static {v0, v1, v2}, Labq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V

    :cond_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->o:Lvv;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->o:Lvv;

    iget-object v0, v0, Lvv;->d:Ljava/util/List;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->b:Ljava/lang/String;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->j:Labd;

    iget-object v4, v4, Labd;->o:Lvv;

    iget-object v5, v4, Lvv;->d:Ljava/util/List;

    move v4, p1

    invoke-static/range {v0 .. v5}, Lwb;->a(Landroid/content/Context;Ljava/lang/String;Labd;Ljava/lang/String;ZLjava/util/List;)V

    :cond_3
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->l:Lvu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->l:Lvu;

    iget-object v0, v0, Lvu;->f:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->b:Ljava/lang/String;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->j:Labd;

    iget-object v4, v4, Labd;->l:Lvu;

    iget-object v5, v4, Lvu;->f:Ljava/util/List;

    move v4, p1

    invoke-static/range {v0 .. v5}, Lwb;->a(Landroid/content/Context;Ljava/lang/String;Labd;Ljava/lang/String;ZLjava/util/List;)V

    goto/16 :goto_0
.end method

.method private b(Labd;)Z
    .locals 5

    const/4 v2, 0x1

    const/4 v1, 0x0

    iget-boolean v0, p1, Labd;->k:Z

    if-eqz v0, :cond_5

    :try_start_0
    iget-object v0, p1, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->a()Lry;

    move-result-object v0

    invoke-static {v0}, Lsb;->a(Lry;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->a:Lahj;

    invoke-virtual {v3}, Lahj;->getNextView()Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->a:Lahj;

    invoke-virtual {v4, v3}, Lahj;->removeView(Landroid/view/View;)V

    :cond_0
    :try_start_1
    invoke-direct {p0, v0}, Lahi;->b(Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    :cond_1
    :goto_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getChildCount()I

    move-result v0

    if-le v0, v2, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->showNext()V

    :cond_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getNextView()Landroid/view/View;

    move-result-object v0

    instance-of v3, v0, Lcom/google/android/gms/internal/gu;

    if-eqz v3, :cond_6

    check-cast v0, Lcom/google/android/gms/internal/gu;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->c:Landroid/content/Context;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->i:Lcom/google/android/gms/internal/ay;

    invoke-virtual {v0, v3, v4}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;)V

    :cond_3
    :goto_1
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    if-eqz v0, :cond_4

    :try_start_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->c()V
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_2

    :cond_4
    :goto_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0, v1}, Lahj;->setVisibility(I)V

    move v0, v2

    :goto_3
    return v0

    :catch_0
    move-exception v0

    const-string v2, "Could not get View from mediation adapter."

    invoke-static {v2, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move v0, v1

    goto :goto_3

    :catch_1
    move-exception v0

    const-string v2, "Could not add mediation view to view hierarchy."

    invoke-static {v2, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    move v0, v1

    goto :goto_3

    :cond_5
    iget-object v0, p1, Labd;->r:Lcom/google/android/gms/internal/ay;

    if-eqz v0, :cond_1

    iget-object v0, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    iget-object v3, p1, Labd;->r:Lcom/google/android/gms/internal/ay;

    invoke-virtual {v0, v3}, Lcom/google/android/gms/internal/gu;->a(Lcom/google/android/gms/internal/ay;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->removeAllViews()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget-object v3, p1, Labd;->r:Lcom/google/android/gms/internal/ay;

    iget v3, v3, Lcom/google/android/gms/internal/ay;->g:I

    invoke-virtual {v0, v3}, Lahj;->setMinimumWidth(I)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget-object v3, p1, Labd;->r:Lcom/google/android/gms/internal/ay;

    iget v3, v3, Lcom/google/android/gms/internal/ay;->d:I

    invoke-virtual {v0, v3}, Lahj;->setMinimumHeight(I)V

    iget-object v0, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-direct {p0, v0}, Lahi;->b(Landroid/view/View;)V

    goto/16 :goto_0

    :cond_6
    if-eqz v0, :cond_3

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->a:Lahj;

    invoke-virtual {v3, v0}, Lahj;->removeView(Landroid/view/View;)V

    goto :goto_1

    :catch_2
    move-exception v0

    const-string v0, "Could not destroy previous mediation adapter."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_2
.end method

.method private w()V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->g:Landroid/content/ComponentCallbacks;

    invoke-virtual {v0, v1}, Landroid/content/Context;->registerComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    :cond_0
    return-void
.end method

.method private x()V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->g:Landroid/content/ComponentCallbacks;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    :cond_0
    return-void
.end method

.method private y()V
    .locals 2

    const-string v0, "Ad closing."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    invoke-interface {v0}, Ltn;->a()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call AdListener.onAdClosed()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private z()V
    .locals 2

    const-string v0, "Ad leaving application."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->f:Ltn;

    invoke-interface {v0}, Ltn;->b()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call AdListener.onAdLeftApplication()."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method a(Lsy;)Landroid/os/Bundle;
    .locals 6

    const/4 v5, 0x1

    const/4 v0, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-virtual {p1}, Lsy;->e()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p1}, Lsy;->c()V

    :cond_2
    invoke-virtual {p1}, Lsy;->b()Lsv;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lsv;->b()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "In AdManger: loadAd, "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lsv;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lacb;->a(Ljava/lang/String;)V

    :goto_1
    if-eqz v1, :cond_0

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, v5}, Landroid/os/Bundle;-><init>(I)V

    const-string v2, "fingerprint"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "v"

    invoke-virtual {v0, v1, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_0

    :cond_3
    move-object v1, v0

    goto :goto_1
.end method

.method public a()Lry;
    .locals 1

    const-string v0, "getAdFrame must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-static {v0}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v0

    return-object v0
.end method

.method public a(Labd;)V
    .locals 9

    const/4 v8, 0x0

    const/4 v2, 0x3

    const/4 v7, -0x2

    const/4 v4, 0x0

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v8, v0, Lahk;->h:Labn;

    iget-object v0, p1, Labd;->w:Lut;

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    move v6, v0

    :goto_0
    iget v0, p1, Labd;->d:I

    if-eq v0, v7, :cond_0

    iget v0, p1, Labd;->d:I

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    invoke-virtual {v0}, Lahk;->a()Ljava/util/HashSet;

    move-result-object v0

    invoke-static {v0}, Labi;->a(Ljava/util/HashSet;)V

    :cond_0
    iget v0, p1, Labd;->d:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_3

    :cond_1
    :goto_1
    return-void

    :cond_2
    move v6, v4

    goto :goto_0

    :cond_3
    invoke-virtual {p0, p1, v6}, Lahi;->a(Labd;Z)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, "Ad refresh scheduled."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    :cond_4
    iget v0, p1, Labd;->d:I

    if-ne v0, v2, :cond_5

    iget-object v0, p1, Labd;->o:Lvv;

    if-eqz v0, :cond_5

    iget-object v0, p1, Labd;->o:Lvv;

    iget-object v0, v0, Lvv;->e:Ljava/util/List;

    if-eqz v0, :cond_5

    const-string v0, "Pinging no fill URLs."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v3, v2, Lahk;->b:Ljava/lang/String;

    iget-object v2, p1, Labd;->o:Lvv;

    iget-object v5, v2, Lvv;->e:Ljava/util/List;

    move-object v2, p1

    invoke-static/range {v0 .. v5}, Lwb;->a(Landroid/content/Context;Ljava/lang/String;Labd;Ljava/lang/String;ZLjava/util/List;)V

    :cond_5
    iget v0, p1, Labd;->d:I

    if-eq v0, v7, :cond_6

    iget v0, p1, Labd;->d:I

    invoke-direct {p0, v0}, Lahi;->a(I)V

    goto :goto_1

    :cond_6
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_8

    if-nez v6, :cond_8

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_8

    invoke-direct {p0, p1}, Lahi;->b(Labd;)Z

    move-result v0

    if-nez v0, :cond_7

    invoke-direct {p0, v4}, Lahi;->a(I)V

    goto :goto_1

    :cond_7
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-static {v0}, Lahj;->a(Lahj;)Labu;

    move-result-object v0

    iget-object v1, p1, Labd;->v:Ljava/lang/String;

    invoke-virtual {v0, v1}, Labu;->a(Ljava/lang/String;)V

    :cond_8
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->p:Lvx;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->p:Lvx;

    invoke-virtual {v0, v8}, Lvx;->a(Lvw;)V

    :cond_9
    iget-object v0, p1, Labd;->p:Lvx;

    if-eqz v0, :cond_a

    iget-object v0, p1, Labd;->p:Lvx;

    invoke-virtual {v0, p0}, Lvx;->a(Lvw;)V

    :cond_a
    iget-object v0, p0, Lahi;->e:Lso;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    invoke-virtual {v0, v1}, Lso;->b(Labd;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->j:Labd;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    iget-wide v2, p1, Labd;->t:J

    invoke-virtual {v0, v2, v3}, Labf;->a(J)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    iget-wide v2, p1, Labd;->u:J

    invoke-virtual {v0, v2, v3}, Labf;->b(J)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v1, v1, Lcom/google/android/gms/internal/ay;->e:Z

    invoke-virtual {v0, v1}, Labf;->a(Z)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    iget-boolean v1, p1, Labd;->k:Z

    invoke-virtual {v0, v1}, Labf;->b(Z)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_b

    if-nez v6, :cond_b

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_b

    invoke-direct {p0, v4}, Lahi;->b(Z)V

    :cond_b
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->u:Labl;

    if-nez v0, :cond_c

    iget-object v0, p0, Lahi;->c:Lahk;

    new-instance v1, Labl;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->b:Ljava/lang/String;

    invoke-direct {v1, v2}, Labl;-><init>(Ljava/lang/String;)V

    iput-object v1, v0, Lahk;->u:Labl;

    :cond_c
    iget-object v0, p1, Labd;->o:Lvv;

    if-eqz v0, :cond_14

    iget-object v0, p1, Labd;->o:Lvv;

    iget v1, v0, Lvv;->h:I

    iget-object v0, p1, Labd;->o:Lvv;

    iget v0, v0, Lvv;->i:I

    :goto_2
    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->u:Labl;

    invoke-virtual {v2, v1, v0}, Labl;->a(II)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_13

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_e

    iget-object v0, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_e

    iget-object v0, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    invoke-virtual {v0}, Lace;->b()Z

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p1, Labd;->j:Lorg/json/JSONObject;

    if-eqz v0, :cond_e

    :cond_d
    iget-object v0, p0, Lahi;->e:Lso;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    invoke-virtual {v0, v1, v2}, Lso;->a(Lcom/google/android/gms/internal/ay;Labd;)Lsp;

    move-result-object v0

    iget-object v1, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v1

    invoke-virtual {v1}, Lace;->b()Z

    move-result v1

    if-eqz v1, :cond_e

    if-eqz v0, :cond_e

    new-instance v1, Lsj;

    iget-object v2, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-direct {v1, v2}, Lsj;-><init>(Lcom/google/android/gms/internal/gu;)V

    invoke-virtual {v0, v1}, Lsp;->a(Lsm;)V

    :cond_e
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_f

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->a()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    invoke-virtual {v0}, Lace;->c()V

    :cond_f
    if-eqz v6, :cond_10

    iget-object v0, p1, Labd;->w:Lut;

    instance-of v1, v0, Lur;

    if-eqz v1, :cond_11

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->q:Luz;

    if-eqz v1, :cond_11

    invoke-direct {p0}, Lahi;->D()V

    :cond_10
    :goto_3
    invoke-direct {p0}, Lahi;->B()V

    goto/16 :goto_1

    :cond_11
    instance-of v0, v0, Luq;

    if-eqz v0, :cond_12

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->p:Luy;

    if-eqz v0, :cond_12

    invoke-direct {p0}, Lahi;->C()V

    goto :goto_3

    :cond_12
    const-string v0, "No matching listener for retrieved native ad template."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    invoke-direct {p0, v4}, Lahi;->a(I)V

    goto/16 :goto_1

    :cond_13
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->v:Landroid/view/View;

    if-eqz v0, :cond_1

    iget-object v0, p1, Labd;->j:Lorg/json/JSONObject;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->e:Lso;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->j:Labd;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->v:Landroid/view/View;

    iget-object v5, p0, Lahi;->c:Lahk;

    iget-object v5, v5, Lahk;->e:Lcom/google/android/gms/internal/gs;

    invoke-virtual/range {v0 .. v5}, Lso;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Labd;Landroid/view/View;Lcom/google/android/gms/internal/gs;)Lsp;

    goto/16 :goto_1

    :cond_14
    move v0, v4

    move v1, v4

    goto/16 :goto_2
.end method

.method public a(Labe;)V
    .locals 9

    const/4 v3, 0x0

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v3, v0, Lahk;->g:Labn;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->k:Labe;

    invoke-virtual {p0, v3}, Lahi;->a(Ljava/util/List;)V

    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->t:Z

    if-nez v0, :cond_4

    new-instance v0, Lahl;

    invoke-direct {v0}, Lahl;-><init>()V

    invoke-direct {p0, v0}, Lahi;->a(Lahl;)Lcom/google/android/gms/internal/gu;

    move-result-object v2

    new-instance v1, Lahn;

    invoke-direct {v1, p1, v2}, Lahn;-><init>(Labe;Lcom/google/android/gms/internal/gu;)V

    invoke-virtual {v0, v1}, Lahl;->a(Lahm;)V

    new-instance v1, Lahi$2;

    invoke-direct {v1, p0, v0}, Lahi$2;-><init>(Lahi;Lahl;)V

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/gu;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    new-instance v1, Lahi$3;

    invoke-direct {v1, p0, v0}, Lahi$3;-><init>(Lahi;Lahl;)V

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/gu;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :goto_0
    iget-object v0, p1, Labe;->d:Lcom/google/android/gms/internal/ay;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v1, p1, Labe;->d:Lcom/google/android/gms/internal/ay;

    iput-object v1, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    :cond_0
    iget v0, p1, Labe;->e:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_1

    new-instance v0, Labd;

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-direct/range {v0 .. v7}, Labd;-><init>(Labe;Lcom/google/android/gms/internal/gu;Lvu;Lwg;Ljava/lang/String;Lvx;Lut;)V

    invoke-virtual {p0, v0}, Lahi;->a(Labd;)V

    :goto_1
    return-void

    :cond_1
    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->h:Z

    if-nez v0, :cond_3

    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->s:Z

    if-eqz v0, :cond_3

    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->b:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/net/Uri$Builder;->query(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    :cond_2
    new-instance v0, Luh;

    iget-object v1, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->c:Ljava/lang/String;

    invoke-direct {v0, p0, v3, v1}, Luh;-><init>(Laho;Ljava/lang/String;Ljava/lang/String;)V

    :try_start_0
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->r:Lum;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lahi;->c:Lahk;

    const/4 v3, 0x1

    iput v3, v1, Lahk;->w:I

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->r:Lum;

    invoke-interface {v1, v0}, Lum;->a(Luj;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    const-string v1, "Could not call the onCustomRenderedAdLoadedListener."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_3
    iget-object v0, p0, Lahi;->c:Lahk;

    const/4 v1, 0x0

    iput v1, v0, Lahk;->w:I

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v3, v1, Lahk;->c:Landroid/content/Context;

    iget-object v7, p0, Lahi;->b:Lwd;

    move-object v4, p0

    move-object v5, p1

    move-object v6, v2

    move-object v8, p0

    invoke-static/range {v3 .. v8}, Laaa;->a(Landroid/content/Context;Lahi;Labe;Lcom/google/android/gms/internal/gu;Lwd;Laab;)Labn;

    move-result-object v1

    iput-object v1, v0, Lahk;->h:Labn;

    goto :goto_1

    :cond_4
    move-object v2, v3

    goto/16 :goto_0
.end method

.method public a(Landroid/view/View;)V
    .locals 8

    const/4 v2, 0x0

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->v:Landroid/view/View;

    new-instance v0, Labd;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->k:Labe;

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move-object v7, v2

    invoke-direct/range {v0 .. v7}, Labd;-><init>(Labe;Lcom/google/android/gms/internal/gu;Lvu;Lwg;Ljava/lang/String;Lvx;Lut;)V

    invoke-virtual {p0, v0}, Lahi;->a(Labd;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/internal/ay;)V
    .locals 2

    const-string v0, "setAdSize must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/gu;->a(Lcom/google/android/gms/internal/ay;)V

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getChildCount()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->a:Lahj;

    invoke-virtual {v1}, Lahj;->getNextView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lahj;->removeView(Landroid/view/View;)V

    :cond_1
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget v1, p1, Lcom/google/android/gms/internal/ay;->g:I

    invoke-virtual {v0, v1}, Lahj;->setMinimumWidth(I)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget v1, p1, Lcom/google/android/gms/internal/ay;->d:I

    invoke-virtual {v0, v1}, Lahj;->setMinimumHeight(I)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->requestLayout()V

    return-void
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->m:Ltw;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->m:Ltw;

    invoke-interface {v0, p1, p2}, Ltw;->a(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not call the AppEventListener."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v3, 0x0

    new-instance v0, Lxw;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v2, v2, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    invoke-direct {v0, p1, p2, v1, v2}, Lxw;-><init>(Ljava/lang/String;Ljava/util/ArrayList;Landroid/content/Context;Ljava/lang/String;)V

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->o:Lyj;

    if-nez v1, :cond_5

    const-string v1, "InAppPurchaseListener is not set. Try to launch default purchase flow."

    invoke-static {v1}, Lacb;->e(Ljava/lang/String;)V

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    invoke-static {v1}, Lpu;->a(Landroid/content/Context;)I

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, "Google Play Service unavailable, cannot launch default purchase flow."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->n:Lyv;

    if-nez v1, :cond_1

    const-string v0, "PlayStorePurchaseListener is not set."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->t:Lye;

    if-nez v1, :cond_2

    const-string v0, "PlayStorePurchaseVerifier is not initialized."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-boolean v1, v1, Lahk;->x:Z

    if-eqz v1, :cond_3

    const-string v0, "An in-app purchase request is already in progress, abort"

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    iget-object v1, p0, Lahi;->c:Lahk;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lahk;->x:Z

    :try_start_0
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->n:Lyv;

    invoke-interface {v1, p1}, Lyv;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v0, p0, Lahi;->c:Lahk;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lahk;->x:Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v0, "Could not start In-App purchase."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-boolean v3, v0, Lahk;->x:Z

    goto :goto_0

    :cond_4
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/gs;->e:Z

    new-instance v3, Lcom/google/android/gms/internal/ea;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->c:Landroid/content/Context;

    iget-object v5, p0, Lahi;->c:Lahk;

    iget-object v5, v5, Lahk;->t:Lye;

    invoke-direct {v3, v4, v5, v0, p0}, Lcom/google/android/gms/internal/ea;-><init>(Landroid/content/Context;Lye;Lyg;Lyd;)V

    invoke-static {v1, v2, v3}, Lxx;->a(Landroid/content/Context;ZLcom/google/android/gms/internal/ea;)V

    goto :goto_0

    :cond_5
    :try_start_1
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->o:Lyj;

    invoke-interface {v1, v0}, Lyj;->a(Lyg;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v0, "Could not start In-App purchase."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V
    .locals 8

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->n:Lyv;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v7, v0, Lahk;->n:Lyv;

    new-instance v0, Lxz;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    move-object v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lxz;-><init>(Landroid/content/Context;Ljava/lang/String;ZILandroid/content/Intent;Lxy;)V

    invoke-interface {v7, v0}, Lyv;->a(Lys;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    sget-object v0, Laca;->a:Landroid/os/Handler;

    new-instance v1, Lahi$4;

    invoke-direct {v1, p0, p4}, Lahi$4;-><init>(Lahi;Landroid/content/Intent;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    :catch_0
    move-exception v0

    const-string v0, "Fail to invoke PlayStorePurchaseListener."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(Ljava/util/HashSet;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lahi;->c:Lahk;

    invoke-virtual {v0, p1}, Lahk;->a(Ljava/util/HashSet;)V

    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "setNativeTemplates must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->s:Ljava/util/List;

    return-void
.end method

.method public a(Ltn;)V
    .locals 1

    const-string v0, "setAdListener must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->f:Ltn;

    return-void
.end method

.method public a(Ltw;)V
    .locals 1

    const-string v0, "setAppEventListener must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->m:Ltw;

    return-void
.end method

.method public a(Lum;)V
    .locals 1

    const-string v0, "setOnCustomRenderedAdLoadedListener must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->r:Lum;

    return-void
.end method

.method public a(Lyj;)V
    .locals 1

    const-string v0, "setInAppPurchaseListener must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->o:Lyj;

    return-void
.end method

.method public a(Lyv;Ljava/lang/String;)V
    .locals 4

    const-string v0, "setPlayStorePurchaseParams must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    new-instance v1, Lye;

    invoke-direct {v1, p2}, Lye;-><init>(Ljava/lang/String;)V

    iput-object v1, v0, Lahk;->t:Lye;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object p1, v0, Lahk;->n:Lyv;

    invoke-static {}, Labi;->h()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    new-instance v0, Lxv;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->n:Lyv;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->t:Lye;

    invoke-direct {v0, v1, v2, v3}, Lxv;-><init>(Landroid/content/Context;Lyv;Lye;)V

    invoke-virtual {v0}, Lxv;->e()V

    :cond_0
    return-void
.end method

.method public a(Z)V
    .locals 1

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-boolean p1, v0, Lahk;->y:Z

    return-void
.end method

.method a(Labd;Z)Z
    .locals 7

    const-wide/16 v4, 0x0

    const/4 v0, 0x0

    iget-object v1, p0, Lahi;->a:Lcom/google/android/gms/internal/av;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lahi;->a:Lcom/google/android/gms/internal/av;

    const/4 v2, 0x0

    iput-object v2, p0, Lahi;->a:Lcom/google/android/gms/internal/av;

    move-object v6, v1

    move v1, v0

    move-object v0, v6

    :goto_0
    or-int/2addr v1, p2

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v2, :cond_3

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p1, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->a(Landroid/webkit/WebView;)V

    :cond_0
    :goto_1
    iget-object v0, p0, Lahi;->d:Lsk;

    invoke-virtual {v0}, Lsk;->d()Z

    move-result v0

    return v0

    :cond_1
    iget-object v1, p1, Labd;->a:Lcom/google/android/gms/internal/av;

    iget-object v2, v1, Lcom/google/android/gms/internal/av;->c:Landroid/os/Bundle;

    if-eqz v2, :cond_2

    iget-object v2, v1, Lcom/google/android/gms/internal/av;->c:Landroid/os/Bundle;

    const-string v3, "_noRefresh"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    :cond_2
    move-object v6, v1

    move v1, v0

    move-object v0, v6

    goto :goto_0

    :cond_3
    if-nez v1, :cond_0

    iget-object v1, p0, Lahi;->c:Lahk;

    iget v1, v1, Lahk;->w:I

    if-nez v1, :cond_0

    iget-wide v2, p1, Labd;->h:J

    cmp-long v1, v2, v4

    if-lez v1, :cond_4

    iget-object v1, p0, Lahi;->d:Lsk;

    iget-wide v2, p1, Labd;->h:J

    invoke-virtual {v1, v0, v2, v3}, Lsk;->a(Lcom/google/android/gms/internal/av;J)V

    goto :goto_1

    :cond_4
    iget-object v1, p1, Labd;->o:Lvv;

    if-eqz v1, :cond_5

    iget-object v1, p1, Labd;->o:Lvv;

    iget-wide v2, v1, Lvv;->g:J

    cmp-long v1, v2, v4

    if-lez v1, :cond_5

    iget-object v1, p0, Lahi;->d:Lsk;

    iget-object v2, p1, Labd;->o:Lvv;

    iget-wide v2, v2, Lvv;->g:J

    invoke-virtual {v1, v0, v2, v3}, Lsk;->a(Lcom/google/android/gms/internal/av;J)V

    goto :goto_1

    :cond_5
    iget-boolean v1, p1, Labd;->k:Z

    if-nez v1, :cond_0

    iget v1, p1, Labd;->d:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lahi;->d:Lsk;

    invoke-virtual {v1, v0}, Lsk;->a(Lcom/google/android/gms/internal/av;)V

    goto :goto_1
.end method

.method public a(Lcom/google/android/gms/internal/av;)Z
    .locals 4

    const/4 v0, 0x0

    const-string v1, "loadAd must be called on the main UI thread."

    invoke-static {v1}, Lady;->b(Ljava/lang/String;)V

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->g:Labn;

    if-nez v1, :cond_0

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->h:Labn;

    if-eqz v1, :cond_3

    :cond_0
    iget-object v1, p0, Lahi;->a:Lcom/google/android/gms/internal/av;

    if-eqz v1, :cond_1

    const-string v1, "Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes."

    invoke-static {v1}, Lacb;->e(Ljava/lang/String;)V

    :cond_1
    iput-object p1, p0, Lahi;->a:Lcom/google/android/gms/internal/av;

    :cond_2
    :goto_0
    return v0

    :cond_3
    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v1, v1, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v1, :cond_4

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    if-eqz v1, :cond_4

    const-string v1, "An interstitial is already loading. Aborting."

    invoke-static {v1}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_4
    invoke-virtual {p0}, Lahi;->t()Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "Starting ad request."

    invoke-static {v1}, Lacb;->c(Ljava/lang/String;)V

    iget-boolean v1, p1, Lcom/google/android/gms/internal/av;->f:Z

    if-nez v1, :cond_5

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Use AdRequest.Builder.addTestDevice(\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->c:Landroid/content/Context;

    invoke-static {v2}, Laca;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\") to get test ads on this device."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lacb;->c(Ljava/lang/String;)V

    :cond_5
    invoke-static {}, Labi;->a()Labi;

    move-result-object v1

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v1, v2}, Labi;->a(Landroid/content/Context;)Lsy;

    move-result-object v1

    invoke-virtual {p0, v1}, Lahi;->a(Lsy;)Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lahi;->d:Lsk;

    invoke-virtual {v2}, Lsk;->a()V

    iget-object v2, p0, Lahi;->c:Lahk;

    iput v0, v2, Lahk;->w:I

    invoke-direct {p0, p1, v1}, Lahi;->a(Lcom/google/android/gms/internal/av;Landroid/os/Bundle;)Laak;

    move-result-object v0

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->c:Landroid/content/Context;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->d:Laea;

    invoke-static {v2, v0, v3, p0}, Lzg;->a(Landroid/content/Context;Laak;Laea;Lzh;)Labn;

    move-result-object v0

    iput-object v0, v1, Lahk;->g:Labn;

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public b()V
    .locals 2

    const/4 v1, 0x0

    const-string v0, "destroy must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    invoke-direct {p0}, Lahi;->x()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v1, v0, Lahk;->f:Ltn;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v1, v0, Lahk;->m:Ltw;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v1, v0, Lahk;->n:Lyv;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v1, v0, Lahk;->o:Lyj;

    iget-object v0, p0, Lahi;->c:Lahk;

    iput-object v1, v0, Lahk;->r:Lum;

    iget-object v0, p0, Lahi;->d:Lsk;

    invoke-virtual {v0}, Lsk;->a()V

    iget-object v0, p0, Lahi;->e:Lso;

    invoke-virtual {v0}, Lso;->a()V

    invoke-virtual {p0}, Lahi;->g()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->removeAllViews()V

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->destroy()V

    :cond_1
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    if-eqz v0, :cond_2

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->c()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v0, "Could not destroy mediation adapter."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public b(Lcom/google/android/gms/internal/av;)V
    .locals 2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    invoke-virtual {v0}, Lahj;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v1, v0, Landroid/view/View;

    if-eqz v1, :cond_0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Labq;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lahi;->f:Z

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lahi;->a(Lcom/google/android/gms/internal/av;)Z

    :goto_0
    return-void

    :cond_0
    const-string v0, "Ad is not visible. Not refreshing ad."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->d:Lsk;

    invoke-virtual {v0, p1}, Lsk;->a(Lcom/google/android/gms/internal/av;)V

    goto :goto_0
.end method

.method public c()Z
    .locals 1

    const-string v0, "isLoaded must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->g:Labn;

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->h:Labn;

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()V
    .locals 1

    const-string v0, "pause must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->a(Landroid/webkit/WebView;)V

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    if-eqz v0, :cond_1

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->d()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_0
    iget-object v0, p0, Lahi;->e:Lso;

    invoke-virtual {v0}, Lso;->b()V

    iget-object v0, p0, Lahi;->d:Lsk;

    invoke-virtual {v0}, Lsk;->b()V

    return-void

    :catch_0
    move-exception v0

    const-string v0, "Could not pause mediation adapter."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public e()V
    .locals 1

    const-string v0, "resume must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->b(Landroid/webkit/WebView;)V

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    if-eqz v0, :cond_1

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->e()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_0
    iget-object v0, p0, Lahi;->d:Lsk;

    invoke-virtual {v0}, Lsk;->c()V

    iget-object v0, p0, Lahi;->e:Lso;

    invoke-virtual {v0}, Lso;->c()V

    return-void

    :catch_0
    move-exception v0

    const-string v0, "Could not resume mediation adapter."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public f()V
    .locals 9

    const/4 v2, 0x0

    const/4 v1, 0x1

    const-string v0, "showInterstitial must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_1

    const-string v0, "Cannot call showInterstitial on a banner ad."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-nez v0, :cond_2

    const-string v0, "The interstitial has not loaded."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->j()Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "The interstitial is already showing."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->a(Z)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    invoke-virtual {v0}, Lace;->b()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->j:Lorg/json/JSONObject;

    if-eqz v0, :cond_5

    :cond_4
    iget-object v0, p0, Lahi;->e:Lso;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->j:Labd;

    invoke-virtual {v0, v3, v4}, Lso;->a(Lcom/google/android/gms/internal/ay;Labd;)Lsp;

    move-result-object v0

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->j:Labd;

    iget-object v3, v3, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v3

    invoke-virtual {v3}, Lace;->b()Z

    move-result v3

    if-eqz v3, :cond_5

    if-eqz v0, :cond_5

    new-instance v3, Lsj;

    iget-object v4, p0, Lahi;->c:Lahk;

    iget-object v4, v4, Lahk;->j:Labd;

    iget-object v4, v4, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-direct {v3, v4}, Lsj;-><init>(Lcom/google/android/gms/internal/gu;)V

    invoke-virtual {v0, v3}, Lsp;->a(Lsm;)V

    :cond_5
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-boolean v0, v0, Labd;->k:Z

    if-eqz v0, :cond_6

    :try_start_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->m:Lwg;

    invoke-interface {v0}, Lwg;->b()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Could not show interstitial."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0}, Lahi;->E()V

    goto/16 :goto_0

    :cond_6
    new-instance v8, Lcom/google/android/gms/internal/y;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-boolean v0, v0, Lahk;->y:Z

    invoke-direct {v8, v0, v2}, Lcom/google/android/gms/internal/y;-><init>(ZZ)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    iget v0, v3, Landroid/graphics/Rect;->bottom:I

    if-eqz v0, :cond_7

    iget v0, v4, Landroid/graphics/Rect;->bottom:I

    if-eqz v0, :cond_7

    new-instance v8, Lcom/google/android/gms/internal/y;

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-boolean v5, v0, Lahk;->y:Z

    iget v0, v3, Landroid/graphics/Rect;->top:I

    iget v3, v4, Landroid/graphics/Rect;->top:I

    if-ne v0, v3, :cond_8

    move v0, v1

    :goto_1
    invoke-direct {v8, v5, v0}, Lcom/google/android/gms/internal/y;-><init>(ZZ)V

    :cond_7
    new-instance v0, Lcom/google/android/gms/internal/dr;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    iget-object v4, v1, Labd;->b:Lcom/google/android/gms/internal/gu;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    iget v5, v1, Labd;->g:I

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v6, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    iget-object v7, v1, Labd;->v:Ljava/lang/String;

    move-object v1, p0

    move-object v2, p0

    move-object v3, p0

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/dr;-><init>(Lahh;Lxh;Lxj;Lcom/google/android/gms/internal/gu;ILcom/google/android/gms/internal/gs;Ljava/lang/String;Lcom/google/android/gms/internal/y;)V

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->c:Landroid/content/Context;

    invoke-static {v1, v0}, Lxc;->a(Landroid/content/Context;Lcom/google/android/gms/internal/dr;)V

    goto/16 :goto_0

    :cond_8
    move v0, v2

    goto :goto_1
.end method

.method public g()V
    .locals 2

    const-string v0, "stopLoading must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget v0, v0, Lahk;->w:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->b:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->stopLoading()V

    iget-object v0, p0, Lahi;->c:Lahk;

    const/4 v1, 0x0

    iput-object v1, v0, Lahk;->j:Labd;

    :cond_0
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->g:Labn;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->g:Labn;

    invoke-virtual {v0}, Labn;->f()V

    :cond_1
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->h:Labn;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->h:Labn;

    invoke-virtual {v0}, Labn;->f()V

    :cond_2
    return-void
.end method

.method public h()V
    .locals 3

    const-string v0, "recordManualImpression must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-nez v0, :cond_1

    const-string v0, "Ad state was null when trying to ping manual tracking URLs."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "Pinging manual tracking URLs."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->f:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v2, v2, Labd;->f:Ljava/util/List;

    invoke-static {v0, v1, v2}, Labq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0
.end method

.method public i()Lcom/google/android/gms/internal/ay;
    .locals 1

    const-string v0, "getAdSize must be called on the main UI thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->n:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public k()V
    .locals 0

    invoke-virtual {p0}, Lahi;->s()V

    return-void
.end method

.method public l()V
    .locals 0

    invoke-virtual {p0}, Lahi;->p()V

    return-void
.end method

.method public m()V
    .locals 0

    invoke-virtual {p0}, Lahi;->r()V

    return-void
.end method

.method public n()V
    .locals 0

    invoke-virtual {p0}, Lahi;->q()V

    return-void
.end method

.method public o()V
    .locals 2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Mediation adapter "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    iget-object v1, v1, Labd;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " refreshed, but mediation adapters should never refresh."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lahi;->b(Z)V

    invoke-direct {p0}, Lahi;->B()V

    return-void
.end method

.method public p()V
    .locals 2

    iget-object v0, p0, Lahi;->e:Lso;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->j:Labd;

    invoke-virtual {v0, v1}, Lso;->b(Labd;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lahi;->E()V

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lahi;->f:Z

    invoke-direct {p0}, Lahi;->y()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    invoke-virtual {v0}, Labf;->c()V

    return-void
.end method

.method public q()V
    .locals 1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lahi;->b(Z)V

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lahi;->f:Z

    invoke-direct {p0}, Lahi;->A()V

    return-void
.end method

.method public r()V
    .locals 0

    invoke-direct {p0}, Lahi;->z()V

    return-void
.end method

.method public s()V
    .locals 0

    invoke-virtual {p0}, Lahi;->u()V

    return-void
.end method

.method public t()Z
    .locals 5

    const/4 v1, 0x0

    const/4 v0, 0x1

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->c:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "android.permission.INTERNET"

    invoke-static {v2, v3, v4}, Labq;->a(Landroid/content/pm/PackageManager;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    const-string v3, "Missing internet permission in AndroidManifest.xml."

    const-string v4, "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />"

    invoke-static {v0, v2, v3, v4}, Laca;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    move v0, v1

    :cond_1
    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->c:Landroid/content/Context;

    invoke-static {v2}, Labq;->a(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->a:Lahj;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    const-string v3, "Missing AdActivity with android:configChanges in AndroidManifest.xml."

    const-string v4, "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />"

    invoke-static {v0, v2, v3, v4}, Laca;->a(Landroid/view/ViewGroup;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    move v0, v1

    :cond_3
    if-nez v0, :cond_4

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/ay;->e:Z

    if-nez v2, :cond_4

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->a:Lahj;

    invoke-virtual {v2, v1}, Lahj;->setVisibility(I)V

    :cond_4
    return v0
.end method

.method public u()V
    .locals 6

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    if-nez v0, :cond_1

    const-string v0, "Ad state was null when trying to ping click URLs."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "Pinging click URLs."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->l:Labf;

    invoke-virtual {v0}, Labf;->b()V

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->c:Ljava/util/List;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v2, v2, Labd;->c:Ljava/util/List;

    invoke-static {v0, v1, v2}, Labq;->a(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V

    :cond_2
    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->o:Lvv;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->j:Labd;

    iget-object v0, v0, Labd;->o:Lvv;

    iget-object v0, v0, Lvv;->c:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lahi;->c:Lahk;

    iget-object v0, v0, Lahk;->c:Landroid/content/Context;

    iget-object v1, p0, Lahi;->c:Lahk;

    iget-object v1, v1, Lahk;->e:Lcom/google/android/gms/internal/gs;

    iget-object v1, v1, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    iget-object v2, p0, Lahi;->c:Lahk;

    iget-object v2, v2, Lahk;->j:Labd;

    iget-object v3, p0, Lahi;->c:Lahk;

    iget-object v3, v3, Lahk;->b:Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lahi;->c:Lahk;

    iget-object v5, v5, Lahk;->j:Labd;

    iget-object v5, v5, Labd;->o:Lvv;

    iget-object v5, v5, Lvv;->c:Ljava/util/List;

    invoke-static/range {v0 .. v5}, Lwb;->a(Landroid/content/Context;Ljava/lang/String;Labd;Ljava/lang/String;ZLjava/util/List;)V

    goto :goto_0
.end method

.method public v()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lahi;->b(Z)V

    return-void
.end method
