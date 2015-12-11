.class public Lhw;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;"
        }
    .end annotation
.end field

.field private n:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lka;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lhw;->n:I

    .line 29
    iput-object p1, p0, Lhw;->a:Landroid/app/Activity;

    .line 30
    iput-object p2, p0, Lhw;->j:Ljava/lang/String;

    .line 31
    iput-object p3, p0, Lhw;->k:Ljava/lang/String;

    .line 32
    iput-object p4, p0, Lhw;->l:Ljava/lang/String;

    .line 33
    iput-object p5, p0, Lhw;->g:Landroid/view/View;

    .line 34
    return-void
.end method

.method static synthetic a(Lhw;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lhw;->a:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 38
    iget-object v0, p0, Lhw;->j:Ljava/lang/String;

    iget-object v1, p0, Lhw;->k:Ljava/lang/String;

    iget-object v2, p0, Lhw;->l:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhw;->m:Ljava/util/ArrayList;

    .line 39
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lhw;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lhw;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 45
    :cond_0
    iget-object v0, p0, Lhw;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 46
    iget-object v0, p0, Lhw;->a:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Lhw;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    iget-object v1, p0, Lhw;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a(Ljava/util/ArrayList;)V

    .line 51
    :cond_1
    :goto_0
    return-void

    .line 50
    :cond_2
    invoke-virtual {p0}, Lhw;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 4

    .prologue
    .line 55
    iget-object v0, p0, Lhw;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lhw;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 57
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lhw;->a:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 58
    const-string v1, "<b>\nSorry, no meeting times are available on this day.\n \n</b>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'><b> Try Again </b></font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lhw$2;

    invoke-direct {v3, p0}, Lhw$2;-><init>(Lhw;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'>Cancel</font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lhw$1;

    invoke-direct {v3, p0}, Lhw$1;-><init>(Lhw;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 79
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 80
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 81
    return-void
.end method
