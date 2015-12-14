.class public Lcom/livemixtapes/ui/widgets/SearchView;
.super Landroid/widget/RelativeLayout;
.source "SearchView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;,
        Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    }
.end annotation


# static fields
.field public static final ANIMATION_DURATION:J = 0x12cL


# instance fields
.field private buttonCancel:Landroid/widget/Button;

.field private context:Landroid/content/Context;

.field private editTextQuery:Landroid/widget/EditText;

.field private expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

.field private isExpanded:Z

.field private layoutContainer:Landroid/widget/RelativeLayout;

.field private layoutHint:Landroid/widget/LinearLayout;

.field private layoutPanel:Landroid/widget/RelativeLayout;

.field private queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

.field private searchBox:Landroid/widget/LinearLayout;

.field private searchClear:Landroid/widget/ImageButton;

.field private textViewHint:Landroid/widget/TextView;

.field widthHint:I

.field widthPanel:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 54
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 49
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    .line 51
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    .line 56
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView;->init(Landroid/content/Context;)V

    .line 57
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 60
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 49
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    .line 51
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    .line 62
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView;->init(Landroid/content/Context;)V

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    const/4 v0, 0x0

    .line 66
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 49
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    .line 51
    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    .line 68
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView;->init(Landroid/content/Context;)V

    .line 69
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$1(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$10(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    return-object v0
.end method

.method static synthetic access$11(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->textViewHint:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$12(Lcom/livemixtapes/ui/widgets/SearchView;)V
    .locals 0

    .prologue
    .line 347
    invoke-direct {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->updateHintLabel()V

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/ui/widgets/SearchView;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z

    return v0
.end method

.method static synthetic access$3(Lcom/livemixtapes/ui/widgets/SearchView;Z)V
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z

    return-void
.end method

.method static synthetic access$4(Lcom/livemixtapes/ui/widgets/SearchView;Z)V
    .locals 0

    .prologue
    .line 223
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V

    return-void
.end method

.method static synthetic access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    return-object v0
.end method

.method static synthetic access$7(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->searchClear:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$8(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$9(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->buttonCancel:Landroid/widget/Button;

    return-object v0
.end method

.method private attachEvents()V
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutContainer:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$3;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$3;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 144
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->buttonCancel:Landroid/widget/Button;

    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$4;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$4;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 160
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$5;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$5;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 197
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->searchClear:Landroid/widget/ImageButton;

    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$6;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$6;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 205
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$7;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$7;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 221
    return-void
.end method

.method private init(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->context:Landroid/content/Context;

    .line 75
    const-string v1, "layout_inflater"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 76
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f03003b

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 78
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z

    .line 80
    invoke-direct {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->synthesize()V

    .line 82
    invoke-direct {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->attachEvents()V

    .line 84
    invoke-direct {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->updateHintLabel()V

    .line 85
    return-void
.end method

.method private startAnimation(Z)V
    .locals 4
    .param p1, "expand"    # Z

    .prologue
    const-wide/16 v2, 0x12c

    .line 224
    if-eqz p1, :cond_0

    .line 225
    new-instance v0, Lcom/livemixtapes/ui/widgets/SearchView$8;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/widgets/SearchView$8;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    .line 240
    .local v0, "layoutAnimation":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$9;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView$9;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 283
    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 284
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 345
    :goto_0
    return-void

    .line 287
    .end local v0    # "layoutAnimation":Landroid/view/animation/Animation;
    :cond_0
    new-instance v0, Lcom/livemixtapes/ui/widgets/SearchView$10;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/widgets/SearchView$10;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    .line 302
    .restart local v0    # "layoutAnimation":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$11;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView$11;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 342
    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 343
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method

.method private synthesize()V
    .locals 2

    .prologue
    .line 89
    const v1, 0x7f0800fd

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutContainer:Landroid/widget/RelativeLayout;

    .line 90
    const v1, 0x7f080106

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;

    .line 91
    const v1, 0x7f08010c

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->buttonCancel:Landroid/widget/Button;

    .line 92
    const v1, 0x7f080108

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->textViewHint:Landroid/widget/TextView;

    .line 93
    const v1, 0x7f08010a

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    .line 94
    const v1, 0x7f080107

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;

    .line 99
    const v1, 0x7f080086

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->searchBox:Landroid/widget/LinearLayout;

    .line 102
    const v1, 0x7f08010b

    invoke-virtual {p0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->searchClear:Landroid/widget/ImageButton;

    .line 104
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 105
    .local v0, "observer":Landroid/view/ViewTreeObserver;
    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$1;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 115
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 116
    new-instance v1, Lcom/livemixtapes/ui/widgets/SearchView$2;

    invoke-direct {v1, p0}, Lcom/livemixtapes/ui/widgets/SearchView$2;-><init>(Lcom/livemixtapes/ui/widgets/SearchView;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 125
    return-void
.end method

.method private updateHintLabel()V
    .locals 2

    .prologue
    .line 348
    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->getQuery()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 349
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->textViewHint:Landroid/widget/TextView;

    const-string v1, "Search"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 354
    :goto_0
    return-void

    .line 352
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->textViewHint:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->getQuery()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setExpand(Z)V
    .locals 1
    .param p1, "expand"    # Z

    .prologue
    .line 366
    iget-boolean v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z

    if-eq v0, p1, :cond_0

    .line 367
    iput-boolean p1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z

    .line 369
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V

    .line 371
    :cond_0
    return-void
.end method

.method public setOnExpandListener(Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    .prologue
    .line 378
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    .line 379
    return-void
.end method

.method public setOnQueryTextListener(Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    .prologue
    .line 375
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    .line 376
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 1
    .param p1, "q"    # Ljava/lang/String;

    .prologue
    .line 356
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 358
    invoke-direct {p0}, Lcom/livemixtapes/ui/widgets/SearchView;->updateHintLabel()V

    .line 359
    return-void
.end method
