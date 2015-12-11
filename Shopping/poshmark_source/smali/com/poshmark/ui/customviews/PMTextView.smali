.class public Lcom/poshmark/ui/customviews/PMTextView;
.super Landroid/widget/TextView;
.source "PMTextView.java"


# instance fields
.field private fontColor:I

.field private fontName:Ljava/lang/String;

.field link:Lcom/poshmark/utils/CustomLinkMovementMethod;

.field linkClickListener:Lcom/poshmark/utils/TextClickListener;

.field multipleCommentslinkClickListener:Lcom/poshmark/utils/TextClickListener;

.field multipleLikesClickListener:Lcom/poshmark/utils/TextClickListener;

.field nameClickListener:Lcom/poshmark/utils/TextClickListener;

.field parentLayout:Landroid/view/View;

.field textFormatter:Lcom/poshmark/utils/TextFormatter;

.field urlLinkClickListener:Lcom/poshmark/utils/TextClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    .line 112
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$1;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 48
    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$2;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->urlLinkClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 60
    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$3;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->multipleLikesClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 75
    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$4;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->linkClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 90
    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$5;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->multipleCommentslinkClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 105
    new-instance v1, Lcom/poshmark/utils/TextFormatter;

    invoke-direct {v1}, Lcom/poshmark/utils/TextFormatter;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMTextView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 115
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontColor:I

    .line 117
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMCommon:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 118
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontName:Ljava/lang/String;

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontName:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 120
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontName:Ljava/lang/String;

    invoke-static {p1, v1, p0}, Lcom/poshmark/utils/ViewUtils;->setTypefaceForView(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V

    .line 122
    :cond_0
    return-void
.end method


# virtual methods
.method public getFontColor()I
    .locals 1

    .prologue
    .line 182
    iget v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontColor:I

    return v0
.end method

.method public getFontName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->fontName:Ljava/lang/String;

    return-object v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 195
    invoke-super {p0, p1}, Landroid/widget/TextView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 196
    .local v0, "retVal":Z
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->link:Lcom/poshmark/utils/CustomLinkMovementMethod;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->link:Lcom/poshmark/utils/CustomLinkMovementMethod;

    invoke-virtual {v1}, Lcom/poshmark/utils/CustomLinkMovementMethod;->didUserTapOnNonLinkSpan()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 197
    const/4 v0, 0x0

    .line 199
    .end local v0    # "retVal":Z
    :cond_0
    return v0
.end method

.method public performLongClick()Z
    .locals 1

    .prologue
    .line 205
    const/4 v0, 0x0

    return v0
.end method

.method public setComment(Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 136
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 137
    invoke-static {}, Lcom/poshmark/utils/CustomLinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/CustomLinkMovementMethod;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->link:Lcom/poshmark/utils/CustomLinkMovementMethod;

    .line 138
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->link:Lcom/poshmark/utils/CustomLinkMovementMethod;

    new-instance v1, Lcom/poshmark/ui/customviews/PMTextView$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMTextView$6;-><init>(Lcom/poshmark/ui/customviews/PMTextView;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/CustomLinkMovementMethod;->setOnTextClickListener(Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;)V

    .line 162
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->link:Lcom/poshmark/utils/CustomLinkMovementMethod;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 163
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    invoke-virtual {v0, p0, v1, p1}, Lcom/poshmark/utils/TextFormatter;->getClickableCommentString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 164
    return-void
.end method

.method public setLikesMessage(Ljava/util/List;Ljava/lang/String;)V
    .locals 6
    .param p2, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Like;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 172
    .local p1, "likes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 173
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTextView;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTextView;->multipleLikesClickListener:Lcom/poshmark/utils/TextClickListener;

    move-object v1, p0

    move-object v4, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/utils/TextFormatter;->getClickableLikesString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Lcom/poshmark/utils/TextClickListener;Ljava/util/List;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 174
    return-void
.end method

.method public setLinkString(Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 167
    .local p2, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->linkClickListener:Lcom/poshmark/utils/TextClickListener;

    invoke-virtual {v0, p0, v1, p1, p2}, Lcom/poshmark/utils/TextFormatter;->getClickableLinkString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 169
    return-void
.end method

.method public setMultipleCommentsLinkString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;
    .param p2, "listingId"    # Ljava/lang/String;

    .prologue
    .line 177
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->multipleCommentslinkClickListener:Lcom/poshmark/utils/TextClickListener;

    invoke-virtual {v0, p0, v1, p1, p2}, Lcom/poshmark/utils/TextFormatter;->getClickableSimpleString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 179
    return-void
.end method

.method public setParentLayout(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 190
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTextView;->parentLayout:Landroid/view/View;

    .line 191
    return-void
.end method

.method public setTitleWithHtmlString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "userName"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 130
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 132
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->urlLinkClickListener:Lcom/poshmark/utils/TextClickListener;

    invoke-virtual {v0, p0, v1, p1, p2}, Lcom/poshmark/utils/TextFormatter;->getHtmlStringWithClickableLinks(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 133
    return-void
.end method

.method public setUserName(Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 126
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTextView;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTextView;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    invoke-virtual {v0, p0, v1, p1}, Lcom/poshmark/utils/TextFormatter;->getClickableUserNameString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 127
    return-void
.end method
