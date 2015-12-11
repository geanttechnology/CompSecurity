.class public final Lcom/wishabi/flipp/app/i;
.super Landroid/app/DialogFragment;
.source "SourceFile"


# instance fields
.field a:Lcom/wishabi/flipp/app/k;

.field private b:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 62
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/i;)Lcom/wishabi/flipp/app/k;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/app/i;->a:Lcom/wishabi/flipp/app/k;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/i;)I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/wishabi/flipp/app/i;->b:I

    return v0
.end method


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 71
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/i;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "EDIT_MENU_ITEM_KEY"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/i;->b:I

    .line 73
    return-void
.end method

.method public final onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 3

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/i;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 78
    const/4 v0, 0x0

    .line 116
    :goto_0
    return-object v0

    .line 80
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/i;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 82
    iget v1, p0, Lcom/wishabi/flipp/app/i;->b:I

    packed-switch v1, :pswitch_data_0

    .line 96
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Item id must be set before use"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 84
    :pswitch_0
    const v1, 0x7f0e008f

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 85
    const v1, 0x7f0e008e

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    .line 99
    :goto_1
    new-instance v1, Lcom/wishabi/flipp/app/j;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/j;-><init>(Lcom/wishabi/flipp/app/i;)V

    .line 116
    const v2, 0x7f0e0160

    invoke-virtual {v0, v2, v1}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v2, 0x7f0e00e5

    invoke-virtual {v0, v2, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    goto :goto_0

    .line 88
    :pswitch_1
    const v1, 0x7f0e008d

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 89
    const v1, 0x7f0e008c

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    goto :goto_1

    .line 92
    :pswitch_2
    const v1, 0x7f0e008b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 93
    const v1, 0x7f0e008a

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    goto :goto_1

    .line 82
    :pswitch_data_0
    .packed-switch 0x7f0b0152
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
