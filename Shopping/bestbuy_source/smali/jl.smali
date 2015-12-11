.class public Ljl;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput v0, Ljl;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p4, p0, Ljl;->a:Ljava/lang/String;

    .line 26
    iput-object p3, p0, Ljl;->g:Landroid/view/View;

    .line 27
    iput-object p5, p0, Ljl;->k:Ljava/lang/String;

    .line 28
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 16
    sput p0, Ljl;->j:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v5, 0x0

    .line 39
    iget-object v0, p0, Ljl;->a:Ljava/lang/String;

    const-string v1, "search"

    const-string v2, "130"

    const/16 v7, 0xa

    const/4 v8, 0x1

    move-object v4, v3

    move v6, v5

    invoke-static/range {v0 .. v8}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    iput-object v0, p0, Ljl;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 41
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 45
    const/4 v0, 0x0

    sput v0, Ljl;->j:I

    .line 46
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 48
    :cond_0
    iget-object v0, p0, Ljl;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_1

    .line 49
    iget-object v0, p0, Ljl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Ljl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;

    iget-object v1, p0, Ljl;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuList()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Ljl;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->a(Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 53
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 63
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 65
    :cond_0
    iget-object v0, p0, Ljl;->f:Landroid/app/Activity;

    new-instance v1, Ljl$1;

    invoke-direct {v1, p0}, Ljl$1;-><init>(Ljl;)V

    new-instance v2, Ljl$2;

    invoke-direct {v2, p0}, Ljl$2;-><init>(Ljl;)V

    iget-boolean v3, p0, Ljl;->e:Z

    sget v4, Ljl;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 76
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 57
    sget v0, Ljl;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljl;->j:I

    .line 58
    new-instance v0, Ljl;

    iget-object v1, p0, Ljl;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljl;->g:Landroid/view/View;

    iget-object v4, p0, Ljl;->a:Ljava/lang/String;

    iget-object v5, p0, Ljl;->k:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Ljl;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljl;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 59
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 32
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Ljl;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 34
    :cond_0
    return-void
.end method
