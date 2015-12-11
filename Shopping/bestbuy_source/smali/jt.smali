.class public Ljt;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

.field private j:Ljava/lang/String;

.field private l:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput v0, Ljt;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p4, p0, Ljt;->j:Ljava/lang/String;

    .line 27
    iput-object p3, p0, Ljt;->g:Landroid/view/View;

    .line 28
    iput-boolean p5, p0, Ljt;->l:Z

    .line 29
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 17
    sput p0, Ljt;->k:I

    return p0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 17
    sget v0, Ljt;->k:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ljt;->k:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 40
    const/4 v0, 0x0

    sput v0, Ljt;->k:I

    .line 41
    iget-object v0, p0, Ljt;->j:Ljava/lang/String;

    invoke-static {v0}, Lfs;->n(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

    move-result-object v0

    iput-object v0, p0, Ljt;->a:Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

    .line 42
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 52
    const/4 v0, 0x0

    sput v0, Ljt;->k:I

    .line 53
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Ljt;->a:Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Ljt;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 57
    iget-object v0, p0, Ljt;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ljt;->a:Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/ShareURL;->getUrl()Ljava/lang/String;

    move-result-object v1

    iget-boolean v2, p0, Ljt;->l:Z

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->postOnTwitter(Ljava/lang/String;Z)V

    .line 61
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 64
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 66
    :cond_0
    iget-object v0, p0, Ljt;->f:Landroid/app/Activity;

    new-instance v1, Ljt$1;

    invoke-direct {v1, p0}, Ljt$1;-><init>(Ljt;)V

    new-instance v2, Ljt$2;

    invoke-direct {v2, p0}, Ljt$2;-><init>(Ljt;)V

    iget-boolean v3, p0, Ljt;->e:Z

    sget v4, Ljt;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 79
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 46
    sget v0, Ljt;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljt;->k:I

    .line 47
    new-instance v0, Ljt;

    iget-object v1, p0, Ljt;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljt;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljt;->g:Landroid/view/View;

    iget-object v4, p0, Ljt;->j:Ljava/lang/String;

    iget-boolean v5, p0, Ljt;->l:Z

    invoke-direct/range {v0 .. v5}, Ljt;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Z)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljt;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 33
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Ljt;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 36
    :cond_0
    return-void
.end method
