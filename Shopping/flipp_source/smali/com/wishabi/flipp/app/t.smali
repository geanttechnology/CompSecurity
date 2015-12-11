.class final Lcom/wishabi/flipp/app/t;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/n;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/n;)V
    .locals 0

    .prologue
    .line 507
    iput-object p1, p0, Lcom/wishabi/flipp/app/t;->a:Lcom/wishabi/flipp/app/n;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 510
    iget-object v0, p0, Lcom/wishabi/flipp/app/t;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 511
    iget-object v0, p0, Lcom/wishabi/flipp/app/t;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v1, "TutorialPrintCouponDialogTag"

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_1

    sget v0, Lcom/wishabi/flipp/app/fq;->c:I

    .line 513
    :cond_0
    :goto_0
    return-void

    .line 511
    :cond_1
    new-instance v3, Lcom/wishabi/flipp/content/FormattedString;

    const/4 v4, 0x2

    new-array v4, v4, [Lcom/wishabi/flipp/content/FormattedString$Part;

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e014f

    invoke-virtual {v2, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-array v7, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v8, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v9, Lcom/wishabi/flipp/content/ab;->b:I

    invoke-direct {v8, v9}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v8, v7, v10

    invoke-direct {v5, v6, v7}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v4, v10

    new-instance v5, Lcom/wishabi/flipp/content/FormattedString$Part;

    const v6, 0x7f0e0150

    invoke-virtual {v2, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v6, v11, [Lcom/wishabi/flipp/content/FormattedString$Format;

    new-instance v7, Lcom/wishabi/flipp/content/FormattedString$Format;

    sget v8, Lcom/wishabi/flipp/content/ab;->a:I

    invoke-direct {v7, v8}, Lcom/wishabi/flipp/content/FormattedString$Format;-><init>(I)V

    aput-object v7, v6, v10

    invoke-direct {v5, v2, v6}, Lcom/wishabi/flipp/content/FormattedString$Part;-><init>(Ljava/lang/String;[Lcom/wishabi/flipp/content/FormattedString$Format;)V

    aput-object v5, v4, v11

    invoke-direct {v3, v4}, Lcom/wishabi/flipp/content/FormattedString;-><init>([Lcom/wishabi/flipp/content/FormattedString$Part;)V

    const-string v2, "tutorial_showed_print_coupon"

    const v4, 0x7f0200f9

    const v5, 0x7f0200f1

    const/4 v6, 0x0

    invoke-static/range {v0 .. v6}, Lcom/wishabi/flipp/app/fp;->a(Landroid/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Lcom/wishabi/flipp/content/FormattedString;IILcom/wishabi/flipp/app/dq;)I

    goto :goto_0
.end method
