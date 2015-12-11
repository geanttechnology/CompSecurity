.class public abstract Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;
.super Ljava/lang/Object;
.source "NonZeroLengthTextWatcher.java"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field private final mWatched:Landroid/widget/EditText;

.field private mWatchedNonZeroLength:Z


# direct methods
.method public constructor <init>(Landroid/widget/EditText;)V
    .locals 1
    .param p1, "_watched"    # Landroid/widget/EditText;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatched:Landroid/widget/EditText;

    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatched:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 23
    iget-object v0, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatched:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatchedNonZeroLength:Z

    .line 24
    return-void

    .line 23
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 32
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatchedNonZeroLength:Z

    .line 33
    invoke-virtual {p0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->update()V

    .line 34
    return-void

    .line 32
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 39
    return-void
.end method

.method public isWatchedNonZeroLength()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->mWatchedNonZeroLength:Z

    return v0
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 44
    return-void
.end method

.method public abstract update()V
.end method
