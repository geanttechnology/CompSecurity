.class public Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;
.super Landroid/widget/RelativeLayout;
.source "NumericKeypad.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;
    }
.end annotation


# instance fields
.field private backspaceButton:Landroid/view/View;

.field private buttons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private keyPressedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->buttons:Ljava/util/List;

    .line 22
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->init(Landroid/content/Context;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->buttons:Ljava/util/List;

    .line 27
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->init(Landroid/content/Context;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 31
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->buttons:Ljava/util/List;

    .line 32
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->init(Landroid/content/Context;)V

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;)Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->keyPressedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;

    return-object v0
.end method

.method private init(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v10, 0x1

    .line 36
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 37
    .local v3, "layoutInflater":Landroid/view/LayoutInflater;
    sget v8, Lcom/comcast/cim/cmasl/android/util/R$layout;->numeric_keypad:I

    invoke-virtual {v3, v8, p0, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 39
    const/16 v8, 0xa

    new-array v1, v8, [Ljava/lang/Integer;

    const/4 v8, 0x0

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadZero:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    sget v8, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadOne:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v1, v10

    const/4 v8, 0x2

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadTwo:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/4 v8, 0x3

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadThree:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/4 v8, 0x4

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadFour:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/4 v8, 0x5

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadFive:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/4 v8, 0x6

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadSix:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/4 v8, 0x7

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadSeven:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/16 v8, 0x8

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadEight:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    const/16 v8, 0x9

    sget v9, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadNine:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v1, v8

    .line 42
    .local v1, "buttonIds":[Ljava/lang/Integer;
    new-instance v5, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;

    invoke-direct {v5, p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;-><init>(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;)V

    .line 49
    .local v5, "listener":Landroid/view/View$OnClickListener;
    move-object v0, v1

    .local v0, "arr$":[Ljava/lang/Integer;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v7, v0, v2

    .line 50
    .local v7, "viewId":Ljava/lang/Integer;
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-virtual {p0, v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 51
    .local v6, "view":Landroid/widget/TextView;
    invoke-virtual {v6}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 52
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    iget-object v8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->buttons:Ljava/util/List;

    invoke-interface {v8, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 49
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 55
    .end local v6    # "view":Landroid/widget/TextView;
    .end local v7    # "viewId":Ljava/lang/Integer;
    :cond_0
    sget v8, Lcom/comcast/cim/cmasl/android/util/R$id;->keypadBackspace:I

    invoke-virtual {p0, v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->findViewById(I)Landroid/view/View;

    move-result-object v8

    iput-object v8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->backspaceButton:Landroid/view/View;

    .line 56
    iget-object v8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->backspaceButton:Landroid/view/View;

    invoke-virtual {v8, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    return-void
.end method


# virtual methods
.method public setEnabled(Z)V
    .locals 3
    .param p1, "enabled"    # Z

    .prologue
    .line 65
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->setEnabled(Z)V

    .line 66
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->buttons:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 67
    .local v0, "button":Landroid/view/View;
    invoke-virtual {v0, p1}, Landroid/view/View;->setEnabled(Z)V

    goto :goto_0

    .line 69
    .end local v0    # "button":Landroid/view/View;
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->backspaceButton:Landroid/view/View;

    invoke-virtual {v2, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 70
    return-void
.end method

.method public setKeyPressedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;)V
    .locals 0
    .param p1, "keyPressedListener"    # Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->keyPressedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;

    .line 61
    return-void
.end method
