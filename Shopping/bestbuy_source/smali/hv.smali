.class public Lhv;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Landroid/os/Bundle;

.field private n:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lka;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput v0, p0, Lhv;->n:I

    .line 31
    iput-object p1, p0, Lhv;->a:Landroid/app/Activity;

    .line 32
    iput-object p2, p0, Lhv;->j:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Lhv;->k:Ljava/lang/String;

    .line 34
    iput-object p4, p0, Lhv;->l:Ljava/lang/String;

    .line 35
    iput-object p5, p0, Lhv;->m:Landroid/os/Bundle;

    .line 36
    return-void
.end method

.method static synthetic a(Lhv;)I
    .locals 2

    .prologue
    .line 21
    iget v0, p0, Lhv;->n:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lhv;->n:I

    return v0
.end method

.method static synthetic a(Lhv;I)I
    .locals 0

    .prologue
    .line 21
    iput p1, p0, Lhv;->n:I

    return p1
.end method

.method static synthetic b(Lhv;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lhv;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhv;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lhv;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lhv;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lhv;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lhv;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lhv;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lhv;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lhv;->m:Landroid/os/Bundle;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 40
    iget-object v0, p0, Lhv;->j:Ljava/lang/String;

    iget-object v1, p0, Lhv;->k:Ljava/lang/String;

    iget-object v2, p0, Lhv;->l:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 45
    iget-object v0, p0, Lhv;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lhv;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 47
    :cond_0
    iget-object v0, p0, Lhv;->l:Ljava/lang/String;

    invoke-static {v0}, Lfq;->b(Ljava/lang/String;)V

    .line 48
    iget-object v0, p0, Lhv;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Appointment cancelled"

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 49
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lhv;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 50
    iget-object v1, p0, Lhv;->m:Landroid/os/Bundle;

    const-string v2, "blueassist_update"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 51
    iget-object v1, p0, Lhv;->m:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 54
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 55
    iget-object v1, p0, Lhv;->a:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 56
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 60
    iget-object v0, p0, Lhv;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lhv;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    :cond_0
    iget-object v0, p0, Lhv;->a:Landroid/app/Activity;

    new-instance v1, Lhv$1;

    invoke-direct {v1, p0}, Lhv$1;-><init>(Lhv;)V

    new-instance v2, Lhv$2;

    invoke-direct {v2, p0}, Lhv$2;-><init>(Lhv;)V

    iget-boolean v3, p0, Lhv;->e:Z

    iget v4, p0, Lhv;->n:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 75
    return-void
.end method
