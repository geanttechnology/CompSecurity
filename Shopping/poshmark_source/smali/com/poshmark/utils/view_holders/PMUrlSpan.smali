.class public Lcom/poshmark/utils/view_holders/PMUrlSpan;
.super Landroid/text/style/URLSpan;
.source "PMUrlSpan.java"


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
    .line 24
    invoke-direct {p0, p1}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .line 25
    iput-object p1, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->data:Ljava/lang/String;

    .line 26
    iput-object p2, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    .line 27
    iput p3, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->textColor:I

    .line 28
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p4}, Lcom/poshmark/utils/ViewUtils;->getTypefaceFromName(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->typeface:Landroid/graphics/Typeface;

    .line 29
    iput-boolean p5, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->isBold:Z

    .line 30
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->nameClickListener:Lcom/poshmark/utils/TextClickListener;

    iget-object v1, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->data:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/poshmark/utils/TextClickListener;->onClick(Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 35
    iget v0, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->textColor:I

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 36
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 37
    iget-boolean v0, p0, Lcom/poshmark/utils/view_holders/PMUrlSpan;->isBold:Z

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 38
    return-void
.end method
