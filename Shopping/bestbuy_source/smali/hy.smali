.class public Lhy;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lka;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lhy;->o:I

    .line 28
    iput-object p1, p0, Lhy;->a:Landroid/app/Activity;

    .line 29
    iput-object p2, p0, Lhy;->j:Ljava/lang/String;

    .line 30
    iput-object p3, p0, Lhy;->k:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lhy;->l:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Lhy;->m:Ljava/lang/String;

    .line 33
    iput-object p6, p0, Lhy;->n:Ljava/lang/String;

    .line 34
    return-void
.end method

.method static synthetic a(Lhy;)I
    .locals 2

    .prologue
    .line 17
    iget v0, p0, Lhy;->o:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lhy;->o:I

    return v0
.end method

.method static synthetic a(Lhy;I)I
    .locals 0

    .prologue
    .line 17
    iput p1, p0, Lhy;->o:I

    return p1
.end method

.method static synthetic b(Lhy;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lhy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lhy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lhy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->m:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lhy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lhy;->n:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 38
    iget-object v0, p0, Lhy;->j:Ljava/lang/String;

    iget-object v1, p0, Lhy;->k:Ljava/lang/String;

    iget-object v2, p0, Lhy;->l:Ljava/lang/String;

    iget-object v3, p0, Lhy;->m:Ljava/lang/String;

    iget-object v4, p0, Lhy;->n:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3, v4}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    .line 43
    iget-object v0, p0, Lhy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lhy;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-object v0, p0, Lhy;->n:Ljava/lang/String;

    iget-object v1, p0, Lhy;->k:Ljava/lang/String;

    iget-object v2, p0, Lhy;->l:Ljava/lang/String;

    invoke-static {v1, v2}, Lne;->a(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lfq;->a(Ljava/lang/String;J)V

    .line 47
    iget-object v0, p0, Lhy;->a:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Lhy;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lhy;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Ljava/lang/String;)V

    .line 50
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 54
    iget-object v0, p0, Lhy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lhy;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 58
    :cond_0
    iget-object v0, p0, Lhy;->a:Landroid/app/Activity;

    new-instance v1, Lhy$1;

    invoke-direct {v1, p0}, Lhy$1;-><init>(Lhy;)V

    new-instance v2, Lhy$2;

    invoke-direct {v2, p0}, Lhy$2;-><init>(Lhy;)V

    iget-boolean v3, p0, Lhy;->e:Z

    iget v4, p0, Lhy;->o:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 69
    return-void
.end method
