.class public Lcom/poshmark/utils/PMClickableSpan;
.super Landroid/text/style/ClickableSpan;
.source "PMClickableSpan.java"


# instance fields
.field data:Ljava/lang/String;

.field isBold:Z

.field nameClickListener:Lcom/poshmark/utils/TextClickListener;

.field textColor:I

.field typeface:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V
    .locals 1
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "textColor"    # I
    .param p4, "fontName"    # Ljava/lang/String;
    .param p5, "isBold"    # Z

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/poshmark/utils/PMClickableSpan;->data:Ljava/lang/String;

    .line 21
    iput-object p2, p0, Lcom/poshmark/utils/PMClickableSpan;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 22
    iput p3, p0, Lcom/poshmark/utils/PMClickableSpan;->textColor:I

    .line 23
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p4}, Lcom/poshmark/utils/ViewUtils;->getTypefaceFromName(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/PMClickableSpan;->typeface:Landroid/graphics/Typeface;

    .line 24
    iput-boolean p5, p0, Lcom/poshmark/utils/PMClickableSpan;->isBold:Z

    .line 25
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/utils/PMClickableSpan;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    iget-object v1, p0, Lcom/poshmark/utils/PMClickableSpan;->data:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/poshmark/utils/TextClickListener;->onClick(Ljava/lang/String;)V

    .line 37
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 30
    iget v0, p0, Lcom/poshmark/utils/PMClickableSpan;->textColor:I

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 31
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 32
    iget-boolean v0, p0, Lcom/poshmark/utils/PMClickableSpan;->isBold:Z

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 33
    return-void
.end method
