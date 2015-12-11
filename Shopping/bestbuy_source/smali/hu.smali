.class public Lhu;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lka;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lhu;->r:I

    .line 28
    iput-object p1, p0, Lhu;->a:Landroid/app/Activity;

    .line 29
    iput-object p2, p0, Lhu;->j:Ljava/lang/String;

    .line 30
    iput-object p3, p0, Lhu;->k:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lhu;->l:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Lhu;->o:Ljava/lang/String;

    .line 33
    iput-object p6, p0, Lhu;->p:Ljava/lang/String;

    .line 34
    iput-object p7, p0, Lhu;->m:Ljava/lang/String;

    .line 35
    iput-object p8, p0, Lhu;->n:Ljava/lang/String;

    .line 36
    return-void
.end method

.method static synthetic a(Lhu;)I
    .locals 2

    .prologue
    .line 14
    iget v0, p0, Lhu;->r:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lhu;->r:I

    return v0
.end method

.method static synthetic a(Lhu;I)I
    .locals 0

    .prologue
    .line 14
    iput p1, p0, Lhu;->r:I

    return p1
.end method

.method static synthetic b(Lhu;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->o:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->p:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->m:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic i(Lhu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lhu;->n:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    .line 40
    iget-object v0, p0, Lhu;->j:Ljava/lang/String;

    iget-object v1, p0, Lhu;->k:Ljava/lang/String;

    iget-object v2, p0, Lhu;->l:Ljava/lang/String;

    iget-object v3, p0, Lhu;->o:Ljava/lang/String;

    iget-object v4, p0, Lhu;->p:Ljava/lang/String;

    iget-object v5, p0, Lhu;->m:Ljava/lang/String;

    iget-object v6, p0, Lhu;->n:Ljava/lang/String;

    invoke-static/range {v0 .. v6}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lhu;->q:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 45
    iget-object v0, p0, Lhu;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lhu;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 47
    :cond_0
    iget-object v0, p0, Lhu;->a:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Lhu;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lhu;->q:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Ljava/lang/String;)V

    .line 50
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 54
    iget-object v0, p0, Lhu;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lhu;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 58
    :cond_0
    iget-object v0, p0, Lhu;->a:Landroid/app/Activity;

    new-instance v1, Lhu$1;

    invoke-direct {v1, p0}, Lhu$1;-><init>(Lhu;)V

    new-instance v2, Lhu$2;

    invoke-direct {v2, p0}, Lhu$2;-><init>(Lhu;)V

    iget-boolean v3, p0, Lhu;->e:Z

    iget v4, p0, Lhu;->r:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 69
    return-void
.end method
