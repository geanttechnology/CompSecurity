.class public Lcom/comcast/cim/android/view/common/PinKeypadFragment;
.super Landroid/app/DialogFragment;
.source "PinKeypadFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;,
        Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private numericKeypad:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

.field private onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field private pinBoxes:[Landroid/widget/TextView;

.field private pinBuffer:Ljava/lang/String;

.field private pinStatus:Landroid/widget/TextView;

.field private pinValidator:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 25
    const-string v0, ""

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    .line 31
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->isDialogActive()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->showCheckingMessage()V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->numericKeypad:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->showError()V

    return-void
.end method

.method static synthetic access$500(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->clearBuffer()V

    return-void
.end method

.method static synthetic access$600(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinValidator:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;

    return-object v0
.end method

.method private clearBuffer()V
    .locals 1

    .prologue
    .line 151
    const-string v0, ""

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    .line 152
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->refreshPinBoxesState()V

    .line 153
    return-void
.end method

.method private isDialogActive()Z
    .locals 1

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private showCheckingMessage()V
    .locals 3

    .prologue
    .line 147
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinStatus:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->checking_pin:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 148
    return-void
.end method

.method private showError()V
    .locals 3

    .prologue
    .line 143
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinStatus:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/android/R$string;->incorrect_pin:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 144
    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 125
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnCancelListener;->onCancel(Landroid/content/DialogInterface;)V

    .line 128
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinValidator:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;

    if-nez v0, :cond_0

    .line 44
    sget-object v0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Must supply pinValidator"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 45
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->dismiss()V

    .line 51
    :goto_0
    return-void

    .line 50
    :cond_0
    const/4 v0, 0x0

    sget v1, Lcom/comcast/cim/android/R$style;->xfinity_remote_filter_dialog:I

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->setStyle(II)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 55
    sget v1, Lcom/comcast/cim/android/R$layout;->pin_keypad:I

    invoke-virtual {p1, v1, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 57
    .local v0, "layout":Landroid/view/View;
    sget-object v1, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->LOG:Lorg/slf4j/Logger;

    const-string v2, "onCreateView"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 59
    sget v1, Lcom/comcast/cim/android/R$id;->keypad:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    iput-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->numericKeypad:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    .line 60
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->numericKeypad:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    invoke-virtual {v1, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->setKeyPressedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;)V

    .line 63
    const/4 v1, 0x4

    new-array v2, v1, [Landroid/widget/TextView;

    sget v1, Lcom/comcast/cim/android/R$id;->pinBoxOne:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    aput-object v1, v2, v3

    const/4 v3, 0x1

    sget v1, Lcom/comcast/cim/android/R$id;->pinBoxTwo:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    aput-object v1, v2, v3

    const/4 v3, 0x2

    sget v1, Lcom/comcast/cim/android/R$id;->pinBoxThree:I

    .line 64
    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    aput-object v1, v2, v3

    const/4 v3, 0x3

    sget v1, Lcom/comcast/cim/android/R$id;->pinBoxFour:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    aput-object v1, v2, v3

    iput-object v2, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBoxes:[Landroid/widget/TextView;

    .line 65
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->refreshPinBoxesState()V

    .line 67
    sget v1, Lcom/comcast/cim/android/R$id;->pinStatus:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinStatus:Landroid/widget/TextView;

    .line 69
    return-object v0
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 132
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onDismiss(Landroid/content/DialogInterface;)V

    .line 133
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-interface {v0, p1}, Landroid/content/DialogInterface$OnDismissListener;->onDismiss(Landroid/content/DialogInterface;)V

    .line 136
    :cond_0
    return-void
.end method

.method public onKeyPressed(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x4

    const/4 v2, 0x0

    .line 77
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinStatus:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinStatus:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    :cond_0
    if-eqz p1, :cond_3

    .line 83
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-ge v0, v3, :cond_1

    .line 84
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    .line 89
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->refreshPinBoxesState()V

    .line 92
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-ne v0, v3, :cond_2

    .line 94
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->numericKeypad:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    invoke-virtual {v0, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->setEnabled(Z)V

    .line 96
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$1;-><init>(Lcom/comcast/cim/android/view/common/PinKeypadFragment;)V

    const-wide/16 v2, 0x96

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 121
    :cond_2
    return-void

    .line 86
    :cond_3
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 87
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    goto :goto_0
.end method

.method public refreshPinBoxesState()V
    .locals 3

    .prologue
    .line 169
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBoxes:[Landroid/widget/TextView;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 170
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBoxes:[Landroid/widget/TextView;

    aget-object v2, v1, v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinBuffer:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    const-string v1, "*"

    :goto_1
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 169
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 170
    :cond_0
    const-string v1, ""

    goto :goto_1

    .line 172
    :cond_1
    return-void
.end method

.method public setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p1, "onCancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 161
    return-void
.end method

.method public setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 0
    .param p1, "onDismissListener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 165
    return-void
.end method

.method public setPinValidator(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;)V
    .locals 0
    .param p1, "pinValidator"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->pinValidator:Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;

    .line 157
    return-void
.end method
