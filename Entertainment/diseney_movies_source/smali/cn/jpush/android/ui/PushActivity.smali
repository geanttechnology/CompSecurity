.class public Lcn/jpush/android/ui/PushActivity;
.super Landroid/app/Activity;


# static fields
.field private static final z:[Ljava/lang/String;


# instance fields
.field private a:Lcn/jpush/android/data/d;

.field private b:Ljava/lang/String;

.field private c:Lcn/jpush/android/data/g;

.field private d:Lcn/jpush/android/ui/a;

.field private e:Z

.field private f:Landroid/app/ProgressDialog;

.field private g:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/4 v0, 0x4

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, "jsA\u007f>#5"

    const/4 v0, -0x1

    move-object v4, v3

    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v5, v1

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    :cond_0
    move-object v7, v1

    move v8, v6

    move v11, v5

    move-object v5, v1

    move v1, v11

    :goto_1
    aget-char v10, v5, v6

    rem-int/lit8 v9, v8, 0x5

    packed-switch v9, :pswitch_data_0

    const/4 v9, 0x4

    :goto_2
    xor-int/2addr v9, v10

    int-to-char v9, v9

    aput-char v9, v5, v6

    add-int/lit8 v6, v8, 0x1

    if-nez v1, :cond_1

    move-object v5, v7

    move v8, v6

    move v6, v1

    goto :goto_1

    :cond_1
    move v5, v1

    move-object v1, v7

    :cond_2
    if-gt v5, v6, :cond_0

    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v5}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_1

    aput-object v1, v3, v2

    const/4 v2, 0x1

    const-string v1, "nuIc"

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "Et[{he~\rwwk:Ycti:Yu$\u007frBm$!:"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "eixj`mnHLa~iDuj"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    return-void

    :pswitch_3
    const/16 v9, 0xc

    goto :goto_2

    :pswitch_4
    const/16 v9, 0x1a

    goto :goto_2

    :pswitch_5
    const/16 v9, 0x2d

    goto :goto_2

    :pswitch_6
    const/16 v9, 0x1a

    goto :goto_2

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

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/jpush/android/ui/PushActivity;->e:Z

    new-instance v0, Lcn/jpush/android/ui/k;

    invoke-direct {v0, p0}, Lcn/jpush/android/ui/k;-><init>(Lcn/jpush/android/ui/PushActivity;)V

    iput-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    return-void
.end method

.method static synthetic a(Lcn/jpush/android/ui/PushActivity;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->b:Ljava/lang/String;

    return-object v0
.end method

.method private a(Landroid/content/Intent;)V
    .locals 9

    const-wide/16 v7, 0x1f4

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x0

    const/4 v3, 0x2

    sget-object v0, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p1, v0, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    sget-object v0, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v0, v0, v2

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcn/jpush/android/data/d;

    iput-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget-object v0, v0, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    iput-object v0, p0, Lcn/jpush/android/ui/PushActivity;->b:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    if-eqz v0, :cond_0

    :cond_0
    :goto_0
    :pswitch_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget v0, v0, Lcn/jpush/android/data/d;->o:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    aget-object v1, v1, v3

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget v1, v1, Lcn/jpush/android/data/d;->o:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    invoke-static {p0, v0, v4}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;I)V

    :cond_2
    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->finish()V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    invoke-virtual {v0, v5}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    invoke-virtual {v0, v3, v7, v8}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    invoke-virtual {v0, v6}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    invoke-virtual {v0, v6, v7, v8}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic b(Lcn/jpush/android/ui/PushActivity;)Lcn/jpush/android/data/d;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    return-object v0
.end method

.method static synthetic c(Lcn/jpush/android/ui/PushActivity;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->g:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic d(Lcn/jpush/android/ui/PushActivity;)V
    .locals 7

    const/4 v6, 0x1

    const/4 v4, -0x1

    const/4 v5, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    check-cast v0, Lcn/jpush/android/data/s;

    iget-object v1, v0, Lcn/jpush/android/data/s;->a:Ljava/lang/String;

    iget v2, v0, Lcn/jpush/android/data/s;->W:I

    if-nez v2, :cond_0

    invoke-static {v1}, Lcn/jpush/android/data/p;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, v0, Lcn/jpush/android/data/s;->ab:Ljava/lang/String;

    iget-boolean v3, v0, Lcn/jpush/android/data/s;->q:Z

    if-eqz v3, :cond_2

    new-instance v3, Lcn/jpush/android/ui/a;

    invoke-direct {v3, p0, v0}, Lcn/jpush/android/ui/a;-><init>(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    iput-object v3, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    new-instance v3, Lcn/jpush/android/ui/i;

    invoke-direct {v3, p0}, Lcn/jpush/android/ui/i;-><init>(Lcn/jpush/android/ui/PushActivity;)V

    invoke-virtual {v0, v3}, Lcn/jpush/android/ui/a;->a(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v4, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v3}, Lcn/jpush/android/ui/PushActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/io/File;

    sget-object v3, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    aget-object v3, v3, v5

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    invoke-virtual {v0, v2}, Lcn/jpush/android/ui/a;->a(Ljava/lang/String;)V

    :goto_0
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->b:Ljava/lang/String;

    const/16 v1, 0x3e8

    invoke-static {v0, v1, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :cond_0
    :goto_1
    return-void

    :cond_1
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    invoke-virtual {v0, v1}, Lcn/jpush/android/ui/a;->a(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    new-instance v0, Lcn/jpush/android/data/g;

    iget-object v3, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    invoke-direct {v0, p0, v3}, Lcn/jpush/android/data/g;-><init>(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    iput-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    new-instance v0, Ljava/io/File;

    sget-object v3, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    aget-object v3, v3, v5

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    invoke-virtual {v0, v2, v5, v6}, Lcn/jpush/android/data/g;->a(Ljava/lang/String;ZZ)V

    :goto_2
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    invoke-virtual {p0, v0}, Lcn/jpush/android/ui/PushActivity;->setContentView(Landroid/view/View;)V

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    new-instance v1, Lcn/jpush/android/ui/j;

    invoke-direct {v1, p0}, Lcn/jpush/android/ui/j;-><init>(Lcn/jpush/android/ui/PushActivity;)V

    invoke-virtual {v0, v1}, Lcn/jpush/android/data/g;->a(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    invoke-virtual {v0, v1, v5, v6}, Lcn/jpush/android/data/g;->a(Ljava/lang/String;ZZ)V

    goto :goto_2

    :cond_4
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    invoke-static {p0, v0, v5}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;I)V

    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->finish()V

    goto :goto_1
.end method

.method static synthetic e(Lcn/jpush/android/ui/PushActivity;)Landroid/app/ProgressDialog;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->f:Landroid/app/ProgressDialog;

    return-object v0
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    iget-boolean v0, p0, Lcn/jpush/android/ui/PushActivity;->e:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->b:Ljava/lang/String;

    const/16 v1, 0x3f0

    invoke-static {v0, v1, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    :goto_0
    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->finish()V

    return-void

    :cond_0
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->b:Ljava/lang/String;

    const/16 v1, 0x3ee

    invoke-static {v0, v1, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    const/16 v3, 0x400

    const/4 v2, 0x1

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/ui/PushActivity;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcn/jpush/android/data/d;

    iput-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget v0, v0, Lcn/jpush/android/data/d;->z:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iput v2, v0, Lcn/jpush/android/data/d;->z:I

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    const/4 v1, 0x3

    iput v1, v0, Lcn/jpush/android/data/d;->p:I

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    invoke-static {p0, v0}, Lcn/jpush/android/api/m;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    :cond_0
    invoke-virtual {p0, v2}, Lcn/jpush/android/ui/PushActivity;->requestWindowFeature(I)Z

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->a:Lcn/jpush/android/data/d;

    iget-boolean v0, v0, Lcn/jpush/android/data/d;->q:Z

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v3, v3}, Landroid/view/Window;->setFlags(II)V

    :cond_1
    invoke-virtual {p0}, Lcn/jpush/android/ui/PushActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-direct {p0, v0}, Lcn/jpush/android/ui/PushActivity;->a(Landroid/content/Intent;)V

    :goto_0
    return-void

    :cond_2
    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->c:Lcn/jpush/android/data/g;

    invoke-virtual {v0}, Lcn/jpush/android/data/g;->a()V

    :cond_0
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->d:Lcn/jpush/android/ui/a;

    invoke-virtual {v0}, Lcn/jpush/android/ui/a;->a()V

    :cond_1
    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->f:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/jpush/android/ui/PushActivity;->f:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    :cond_2
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/jpush/android/ui/PushActivity;->a(Landroid/content/Intent;)V

    return-void
.end method
