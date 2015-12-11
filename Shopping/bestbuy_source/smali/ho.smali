.class public Lho;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput v0, Lho;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p4, p0, Lho;->a:Ljava/lang/String;

    .line 26
    iput-object p3, p0, Lho;->g:Landroid/view/View;

    .line 27
    iput-object p5, p0, Lho;->j:Ljava/lang/String;

    .line 28
    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 69
    sget-object v0, Lft;->a:Lft;

    iget-object v1, p0, Lho;->a:Ljava/lang/String;

    iget-object v2, p0, Lho;->j:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lfs;->a(Lft;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    move-result-object v0

    iput-object v0, p0, Lho;->k:Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    .line 70
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    .line 39
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 42
    :cond_0
    const/4 v0, 0x0

    sput v0, Lho;->l:I

    .line 43
    iget-object v0, p0, Lho;->k:Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;->getValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    .line 44
    if-eqz v0, :cond_1

    iget-object v1, p0, Lho;->f:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "0.0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 45
    :cond_1
    const-string v0, "0.00"

    .line 51
    :cond_2
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Remaining Balance:\n$"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    iget-object v1, p0, Lho;->f:Landroid/app/Activity;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lho;->f:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->isFinishing()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 65
    :cond_3
    :goto_1
    return-void

    .line 47
    :cond_4
    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 48
    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 49
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 55
    :cond_5
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lho;->f:Landroid/app/Activity;

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 56
    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    iget-object v2, p0, Lho;->f:Landroid/app/Activity;

    const v3, 0x7f080284

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lho$1;

    invoke-direct {v3, p0}, Lho$1;-><init>(Lho;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 62
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 63
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_1
.end method

.method public c()V
    .locals 3

    .prologue
    .line 74
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 77
    :cond_0
    new-instance v0, Lkv;

    iget-object v1, p0, Lho;->f:Landroid/app/Activity;

    const-string v2, "We did not recognize the Gift Card \n number. Please check for accuracy and \n try again."

    invoke-direct {v0, v1, v2}, Lkv;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 78
    invoke-virtual {v0}, Lkv;->a()V

    .line 79
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 88
    sget v0, Lho;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lho;->l:I

    .line 89
    new-instance v0, Lho;

    iget-object v1, p0, Lho;->f:Landroid/app/Activity;

    iget-object v2, p0, Lho;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lho;->g:Landroid/view/View;

    iget-object v4, p0, Lho;->a:Ljava/lang/String;

    iget-object v5, p0, Lho;->j:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lho;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lho;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 90
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lho;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
