.class public Lcom/wishabi/flipp/widget/CustomEditText;
.super Landroid/widget/EditText;
.source "SourceFile"


# instance fields
.field private a:Lcom/wishabi/flipp/widget/av;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0, p1}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method


# virtual methods
.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    .line 38
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomEditText;->a:Lcom/wishabi/flipp/widget/av;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomEditText;->a:Lcom/wishabi/flipp/widget/av;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/av;->a()V

    .line 42
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/EditText;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public setKeyboardDimissedListener(Lcom/wishabi/flipp/widget/av;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CustomEditText;->a:Lcom/wishabi/flipp/widget/av;

    .line 34
    return-void
.end method
