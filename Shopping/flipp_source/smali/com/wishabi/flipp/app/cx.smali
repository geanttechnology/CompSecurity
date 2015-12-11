.class public Lcom/wishabi/flipp/app/cx;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wishabi/flipp/app/dl;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field a:Lcom/wishabi/flipp/app/de;

.field private c:J

.field private d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;"
        }
    .end annotation
.end field

.field private e:F

.field private f:Lcom/wishabi/flipp/content/af;

.field private g:I

.field private h:Landroid/view/LayoutInflater;

.field private i:Lcom/wishabi/flipp/widget/ItemDetailImageView;

.field private j:Landroid/widget/TextView;

.field private k:Landroid/widget/TextView;

.field private l:Landroid/widget/TextView;

.field private m:Landroid/widget/TextView;

.field private n:Landroid/widget/TextView;

.field private o:Landroid/widget/Button;

.field private p:Landroid/widget/TextView;

.field private q:Landroid/widget/TextView;

.field private r:Landroid/widget/TextView;

.field private s:Lcom/wishabi/flipp/widget/ActionButton;

.field private t:Lcom/wishabi/flipp/widget/ActionButton;

.field private u:Lcom/wishabi/flipp/widget/ActionButton;

.field private v:Landroid/view/ViewGroup;

.field private w:Landroid/widget/ScrollView;

.field private x:Landroid/view/View;

.field private y:Landroid/view/MenuItem;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    .line 94
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/wishabi/flipp/app/cx;->e:F

    return-void
.end method

.method public static a(JF)Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 62
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 63
    const-string v1, "SAVE_STATE_ITEM_ID_KEY"

    invoke-virtual {v0, v1, p0, p1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 64
    const-string v1, "SAVE_STATE_ITEM_RATIO_KEY"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 65
    return-object v0
.end method

.method private static a(Lcom/wishabi/flipp/content/af;)Landroid/text/Spanned;
    .locals 4

    .prologue
    .line 332
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 334
    iget-object v1, p0, Lcom/wishabi/flipp/content/af;->k:Ljava/lang/String;

    .line 335
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 336
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "<small>"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</small>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 337
    const-string v1, " "

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 340
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/content/af;->j:Ljava/lang/String;

    .line 341
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 342
    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Z)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 344
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/content/af;->l:Ljava/lang/String;

    .line 345
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    .line 346
    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 347
    const-string v2, " "

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 348
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "<small>"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</small>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 351
    :cond_3
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/cx;)Landroid/view/View;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->x:Landroid/view/View;

    return-object v0
.end method

.method public static a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/cx;
    .locals 1

    .prologue
    .line 74
    new-instance v0, Lcom/wishabi/flipp/app/cx;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/cx;-><init>()V

    .line 75
    invoke-virtual {v0, p0}, Lcom/wishabi/flipp/app/cx;->setArguments(Landroid/os/Bundle;)V

    .line 76
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/cx;Lcom/wishabi/flipp/content/af;)V
    .locals 13

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    const/16 v7, 0x8

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 58
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_2

    :cond_0
    iput-object v4, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->w:Landroid/widget/ScrollView;

    invoke-virtual {v0, v11}, Landroid/widget/ScrollView;->setVisibility(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->w:Landroid/widget/ScrollView;

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->setAlpha(F)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->w:Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v2, p0, Lcom/wishabi/flipp/app/cx;->g:I

    int-to-long v2, v2

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->x:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget v2, p0, Lcom/wishabi/flipp/app/cx;->g:I

    int-to-long v2, v2

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v2, Lcom/wishabi/flipp/app/cz;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/cz;-><init>(Lcom/wishabi/flipp/app/cx;)V

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    iput-object p1, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->i:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    iget v2, p0, Lcom/wishabi/flipp/app/cx;->e:F

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->setRatio(F)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->i:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->g:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->setImageUrl(Ljava/lang/String;)V

    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->f:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_8

    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_8

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->j:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->y:Landroid/view/MenuItem;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->y:Landroid/view/MenuItem;

    invoke-interface {v0, v12}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->a(Lcom/wishabi/flipp/content/af;)Landroid/text/Spanned;

    move-result-object v0

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_9

    invoke-interface {v0}, Landroid/text/Spanned;->length()I

    move-result v0

    if-lez v0, :cond_9

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->k:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    invoke-static {v2}, Lcom/wishabi/flipp/app/cx;->a(Lcom/wishabi/flipp/content/af;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    if-eqz v2, :cond_a

    sget-object v2, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    iget-object v3, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    const v3, 0x7f0e00d6

    new-array v5, v12, [Ljava/lang/Object;

    sget-object v6, Lcom/wishabi/flipp/content/af;->b:Lb/a/a/d/d;

    invoke-virtual {v6, v2}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v11

    invoke-virtual {v0, v3, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :goto_3
    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_d

    if-eqz v0, :cond_d

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_d

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->l:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    if-eqz v2, :cond_e

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    if-eqz v2, :cond_e

    sget-object v2, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    iget-object v3, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    const v3, 0x7f0e00d7

    new-array v5, v12, [Ljava/lang/Object;

    sget-object v6, Lcom/wishabi/flipp/content/af;->b:Lb/a/a/d/d;

    invoke-virtual {v6, v2}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v11

    invoke-virtual {v0, v3, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    :goto_5
    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_f

    if-eqz v0, :cond_f

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_f

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->m:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_6
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-object v0, v0, Lcom/wishabi/flipp/content/af;->n:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_10

    if-eqz v0, :cond_10

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_10

    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0e015b

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    const-string v3, " "

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    invoke-static {v0, v12}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Z)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_7
    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->m:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_11

    if-eqz v0, :cond_11

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_11

    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    iget-boolean v3, p1, Lcom/wishabi/flipp/content/af;->o:Z

    if-eqz v3, :cond_4

    const-string v3, " "

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0e00cd

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    new-instance v3, Landroid/text/style/ForegroundColorSpan;

    const/16 v5, 0xff

    const/16 v6, 0x80

    invoke-static {v5, v6, v11}, Landroid/graphics/Color;->rgb(III)I

    move-result v5

    invoke-direct {v3, v5}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    const/16 v6, 0x21

    invoke-virtual {v2, v3, v0, v5, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    const/high16 v3, -0x10000

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_8
    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->i:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_13

    if-eqz v0, :cond_13

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_13

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->p:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_9
    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->r:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v2, v2, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v2, :cond_14

    if-eqz v0, :cond_14

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_14

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->q:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v5, 0x7f0e00d4

    new-array v6, v12, [Ljava/lang/Object;

    aput-object v0, v6, v11

    invoke-virtual {v3, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_a
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->u:Lcom/wishabi/flipp/widget/ActionButton;

    new-instance v2, Lcom/wishabi/flipp/app/da;

    invoke-direct {v2, p0, p1}, Lcom/wishabi/flipp/app/da;-><init>(Lcom/wishabi/flipp/app/cx;Lcom/wishabi/flipp/content/af;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->t:Ljava/lang/String;

    if-eqz v0, :cond_15

    iget-object v0, p1, Lcom/wishabi/flipp/content/af;->s:Ljava/lang/String;

    if-eqz v0, :cond_15

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->u:Lcom/wishabi/flipp/widget/ActionButton;

    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->t:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ActionButton;->setLabel(Ljava/lang/CharSequence;)V

    :goto_b
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->s:Lcom/wishabi/flipp/widget/ActionButton;

    new-instance v2, Lcom/wishabi/flipp/app/db;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/db;-><init>(Lcom/wishabi/flipp/app/cx;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->t:Lcom/wishabi/flipp/widget/ActionButton;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->t:Lcom/wishabi/flipp/widget/ActionButton;

    new-instance v2, Lcom/wishabi/flipp/app/dc;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/dc;-><init>(Lcom/wishabi/flipp/app/cx;)V

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_5
    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->v:Ljava/util/List;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getView()Landroid/view/View;

    move-result-object v5

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v0, :cond_1a

    if-eqz v2, :cond_1a

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1a

    if-eqz v5, :cond_1a

    const v0, 0x7f0b00f0

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1a

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v3, 0x7f030039

    iget-object v6, p0, Lcom/wishabi/flipp/app/cx;->v:Landroid/view/ViewGroup;

    invoke-virtual {v0, v3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_1a

    const v0, 0x7f0b00ef

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/RatingView;

    const/high16 v6, 0x40000000    # 2.0f

    iget-object v7, p1, Lcom/wishabi/flipp/content/af;->u:Ljava/lang/String;

    if-nez v7, :cond_16

    :goto_c
    mul-float/2addr v1, v6

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/RatingView;->setRating(I)V

    const v0, 0x7f0b00ee

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v6, 0x7f0e0116

    new-array v7, v12, [Ljava/lang/Object;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-virtual {v1, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const v0, 0x7f0b00f0

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_6
    :goto_d
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Lcom/wishabi/flipp/content/ah;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v3, 0x7f030038

    invoke-virtual {v1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    if-eqz v7, :cond_6

    const v1, 0x7f0b00ea

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ah;->a:Ljava/lang/String;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const v1, 0x7f0b00ec

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ah;->e:Ljava/lang/String;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const v1, 0x7f0b00ed

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v8, v2, Lcom/wishabi/flipp/content/ah;->c:Ljava/lang/String;

    iget-object v3, v2, Lcom/wishabi/flipp/content/ah;->d:Ljava/lang/String;

    if-nez v3, :cond_17

    move-object v3, v4

    :goto_e
    if-eqz v8, :cond_18

    if-eqz v3, :cond_18

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " - "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_7
    :goto_f
    const v1, 0x7f0b00eb

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/RatingView;

    const/high16 v3, 0x40000000    # 2.0f

    iget-object v2, v2, Lcom/wishabi/flipp/content/ah;->b:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    mul-float/2addr v2, v3

    float-to-int v2, v2

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/widget/RatingView;->setRating(I)V

    invoke-virtual {v0, v7}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_d

    :cond_8
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    :cond_9
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->k:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2

    :cond_a
    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    if-eqz v2, :cond_b

    sget-object v2, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    iget-object v3, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    const v3, 0x7f0e00d8

    new-array v5, v12, [Ljava/lang/Object;

    sget-object v6, Lcom/wishabi/flipp/content/af;->b:Lb/a/a/d/d;

    invoke-virtual {v6, v2}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v11

    invoke-virtual {v0, v3, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    :cond_b
    iget-object v2, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    if-eqz v2, :cond_c

    sget-object v2, Lcom/wishabi/flipp/content/af;->a:Lb/a/a/d/d;

    iget-object v3, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    const v3, 0x7f0e00d5

    new-array v5, v12, [Ljava/lang/Object;

    sget-object v6, Lcom/wishabi/flipp/content/af;->b:Lb/a/a/d/d;

    invoke-virtual {v6, v2}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v11

    invoke-virtual {v0, v3, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    :cond_c
    move-object v0, v4

    goto/16 :goto_3

    :cond_d
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_4

    :cond_e
    move-object v0, v4

    goto/16 :goto_5

    :cond_f
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->m:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_6

    :cond_10
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_7

    :cond_11
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v0, :cond_12

    iget-boolean v0, p1, Lcom/wishabi/flipp/content/af;->o:Z

    if-eqz v0, :cond_12

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    const v2, 0x7f0e00cd

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    const/16 v2, -0x8000

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_8

    :cond_12
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_8

    :cond_13
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->p:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_9

    :cond_14
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->q:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_a

    :cond_15
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->u:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, v7}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    goto/16 :goto_b

    :cond_16
    iget-object v1, p1, Lcom/wishabi/flipp/content/af;->u:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    goto/16 :goto_c

    :cond_17
    invoke-static {}, Lcom/wishabi/flipp/content/af;->c()Lb/a/a/d/d;

    move-result-object v3

    invoke-static {}, Lcom/wishabi/flipp/content/af;->b()Lb/a/a/d/d;

    move-result-object v9

    iget-object v10, v2, Lcom/wishabi/flipp/content/ah;->d:Ljava/lang/String;

    invoke-virtual {v9, v10}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v9

    invoke-virtual {v3, v9}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_e

    :cond_18
    if-eqz v8, :cond_19

    invoke-virtual {v1, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_f

    :cond_19
    if-eqz v3, :cond_7

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_f

    :cond_1a
    iget-object v1, p1, Lcom/wishabi/flipp/content/af;->x:Ljava/util/List;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v0, :cond_1c

    if-eqz v1, :cond_1c

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1c

    if-eqz v5, :cond_1c

    const v0, 0x7f0b00dd

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1c

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v2, 0x7f030036

    iget-object v3, p0, Lcom/wishabi/flipp/app/cx;->v:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1c

    const v2, 0x7f0b00dd

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1b
    :goto_10
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v6, 0x7f030035

    invoke-virtual {v2, v6, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    if-eqz v2, :cond_1b

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_10

    :cond_1c
    iget-object v1, p1, Lcom/wishabi/flipp/content/af;->w:Ljava/util/List;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/af;->y:Z

    if-eqz v0, :cond_1e

    if-eqz v1, :cond_1e

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1e

    if-eqz v5, :cond_1e

    const v0, 0x7f0b00f3

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1e

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v2, 0x7f03003b

    iget-object v3, p0, Lcom/wishabi/flipp/app/cx;->v:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1e

    const v2, 0x7f0b00f3

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1d
    :goto_11
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1e

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v3, v1

    check-cast v3, Landroid/util/Pair;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v2, 0x7f03003a

    invoke-virtual {v1, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    if-eqz v6, :cond_1d

    const v1, 0x7f0b00f1

    invoke-virtual {v6, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    const v1, 0x7f0b00f2

    invoke-virtual {v6, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {v0, v6}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_11

    :cond_1e
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0, v11, v4, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    invoke-virtual {v0, v12, v4, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto/16 :goto_0
.end method

.method public static b(JF)Lcom/wishabi/flipp/app/cx;
    .locals 2

    .prologue
    .line 69
    invoke-static {p0, p1, p2}, Lcom/wishabi/flipp/app/cx;->a(JF)Landroid/os/Bundle;

    move-result-object v0

    .line 70
    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/cx;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/cx;)Lcom/wishabi/flipp/content/af;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/cx;)J
    .locals 2

    .prologue
    .line 58
    iget-wide v0, p0, Lcom/wishabi/flipp/app/cx;->c:J

    return-wide v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 120
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 122
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x10e0000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/cx;->g:I

    .line 124
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v8, 0x0

    const/4 v3, 0x0

    .line 210
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 211
    if-nez v1, :cond_0

    .line 222
    :goto_0
    return-object v3

    .line 214
    :cond_0
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 216
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v4, "_id = ?"

    new-array v5, v5, [Ljava/lang/String;

    iget-wide v6, p0, Lcom/wishabi/flipp/app/cx;->c:J

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    goto :goto_0

    .line 219
    :pswitch_1
    new-array v0, v5, [J

    iget-wide v2, p0, Lcom/wishabi/flipp/app/cx;->c:J

    aput-wide v2, v0, v8

    invoke-static {v1, v0}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[J)Landroid/content/Loader;

    move-result-object v3

    goto :goto_0

    .line 214
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 255
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 264
    :cond_0
    :goto_0
    return-void

    .line 258
    :cond_1
    const v0, 0x7f100007

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 259
    const v0, 0x7f0b0158

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->y:Landroid/view/MenuItem;

    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->y:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 263
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->y:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/16 v5, 0x8

    .line 130
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/cx;->setHasOptionsMenu(Z)V

    .line 132
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 133
    if-nez v2, :cond_1

    .line 192
    :cond_0
    :goto_0
    return-object v0

    .line 136
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    .line 137
    const v1, 0x7f030037

    const/4 v3, 0x0

    invoke-virtual {p1, v1, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 139
    if-eqz v1, :cond_0

    .line 142
    const v0, 0x7f0b00df

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->v:Landroid/view/ViewGroup;

    .line 143
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->h:Landroid/view/LayoutInflater;

    const v3, 0x7f030034

    iget-object v4, p0, Lcom/wishabi/flipp/app/cx;->v:Landroid/view/ViewGroup;

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 145
    const v0, 0x7f0b00e0

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ItemDetailImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->i:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    .line 147
    const v0, 0x7f0b00e1

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->j:Landroid/widget/TextView;

    .line 148
    const v0, 0x7f0b00e2

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->k:Landroid/widget/TextView;

    .line 149
    const v0, 0x7f0b00e5

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->l:Landroid/widget/TextView;

    .line 150
    const v0, 0x7f0b00e6

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->m:Landroid/widget/TextView;

    .line 151
    const v0, 0x7f0b00e3

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->n:Landroid/widget/TextView;

    .line 152
    const v0, 0x7f0b00e4

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    .line 153
    const v0, 0x7f0b00e7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    .line 155
    const v0, 0x7f0b00e8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->p:Landroid/widget/TextView;

    .line 156
    const v0, 0x7f0b00e9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->q:Landroid/widget/TextView;

    .line 157
    const v0, 0x7f0b008d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->s:Lcom/wishabi/flipp/widget/ActionButton;

    .line 158
    const v0, 0x7f0b00dc

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->t:Lcom/wishabi/flipp/widget/ActionButton;

    .line 159
    const v0, 0x7f0b00db

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->u:Lcom/wishabi/flipp/widget/ActionButton;

    .line 160
    const v0, 0x7f0b00de

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->w:Landroid/widget/ScrollView;

    .line 161
    const v0, 0x7f0b0078

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->x:Landroid/view/View;

    .line 163
    invoke-virtual {v2}, Landroid/app/Activity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v3, "ProximaNova-Regular.otf"

    invoke-static {v0, v3}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 165
    invoke-virtual {v2}, Landroid/app/Activity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    const-string v4, "ProximaNova-Bold.otf"

    invoke-static {v3, v4}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v3

    .line 167
    iget-object v4, p0, Lcom/wishabi/flipp/app/cx;->j:Landroid/widget/TextView;

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->k:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 169
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->n:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 170
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->r:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 172
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v0}, Landroid/widget/Button;->setSingleLine()V

    .line 173
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v0, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 175
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->a()Z

    move-result v0

    if-nez v0, :cond_2

    .line 176
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->t:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, v5}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    .line 178
    :cond_2
    if-eqz p3, :cond_4

    .line 179
    const-string v0, "SAVE_STATE_ITEM_ID_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/wishabi/flipp/app/cx;->c:J

    .line 180
    const-string v0, "SAVE_STATE_ITEM_RATIO_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/cx;->e:F

    .line 190
    :cond_3
    :goto_1
    const v0, 0x7f0e00d3

    invoke-virtual {v2, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/cx;->b(Ljava/lang/String;)V

    move-object v0, v1

    .line 192
    goto/16 :goto_0

    .line 182
    :cond_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 183
    if-eqz v0, :cond_3

    .line 184
    const-string v3, "SAVE_STATE_ITEM_ID_KEY"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/wishabi/flipp/app/cx;->c:J

    .line 185
    const-string v3, "SAVE_STATE_ITEM_RATIO_KEY"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/cx;->e:F

    goto :goto_1
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 8

    .prologue
    const/16 v4, 0x8

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 58
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid loader id requested"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v1, p0, Lcom/wishabi/flipp/app/cx;->s:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    const v0, 0x7f0e002d

    :goto_0
    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/ActionButton;->setLabel(I)V

    :cond_0
    :goto_1
    return-void

    :cond_1
    const v0, 0x7f0e0157

    goto :goto_0

    :pswitch_1
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iget-wide v2, p0, Lcom/wishabi/flipp/app/cx;->c:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_3

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setVisibility(I)V

    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->a:Lcom/wishabi/flipp/app/de;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->a:Lcom/wishabi/flipp/app/de;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/de;->a(Lcom/wishabi/flipp/content/af;)V

    goto :goto_1

    :cond_3
    new-instance v0, Landroid/text/SpannableStringBuilder;

    const-string v1, "  "

    invoke-direct {v0, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020053

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_4

    iget-object v2, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v2}, Landroid/widget/Button;->getTextSize()F

    move-result v2

    float-to-double v2, v2

    const-wide/high16 v4, 0x3ff4000000000000L    # 1.25

    mul-double/2addr v2, v4

    double-to-int v2, v2

    invoke-virtual {v1, v6, v6, v2, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    new-instance v2, Landroid/text/style/ImageSpan;

    invoke-direct {v2, v1}, Landroid/text/style/ImageSpan;-><init>(Landroid/graphics/drawable/Drawable;)V

    const/16 v1, 0x21

    invoke-virtual {v0, v2, v6, v7, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0d0001

    iget-object v3, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/wishabi/flipp/app/cx;->d:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v1, v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    new-instance v1, Lcom/wishabi/flipp/app/dd;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/dd;-><init>(Lcom/wishabi/flipp/app/cx;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v0, v6}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_2

    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->o:Landroid/widget/Button;

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 250
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 268
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v8

    .line 269
    if-eqz v8, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    if-nez v0, :cond_1

    .line 270
    :cond_0
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 303
    :goto_0
    return v0

    .line 272
    :cond_1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b0158

    if-ne v0, v1, :cond_5

    .line 276
    :try_start_0
    invoke-virtual {v8}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const/4 v2, 0x0

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v9, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget v9, v9, Lcom/wishabi/flipp/content/af;->c:I

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 283
    if-eqz v1, :cond_2

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 284
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v2, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v2, v1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    iget-wide v4, p0, Lcom/wishabi/flipp/app/cx;->c:J

    sget-object v3, Lcom/wishabi/flipp/b/o;->f:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v2, v4, v5, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 289
    :cond_2
    if-eqz v1, :cond_3

    .line 290
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 293
    :cond_3
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 294
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0e012a

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    iget-object v4, v4, Lcom/wishabi/flipp/content/af;->d:Ljava/lang/String;

    aput-object v4, v3, v10

    iget-object v4, p0, Lcom/wishabi/flipp/app/cx;->f:Lcom/wishabi/flipp/content/af;

    invoke-virtual {v4}, Lcom/wishabi/flipp/content/af;->a()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 296
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 298
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 299
    invoke-static {v0, v7}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    move v0, v6

    .line 300
    goto :goto_0

    .line 289
    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_1
    if-eqz v1, :cond_4

    .line 290
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_4
    throw v0

    .line 303
    :cond_5
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto/16 :goto_0

    .line 289
    :catchall_1
    move-exception v0

    goto :goto_1
.end method

.method public onResume()V
    .locals 6

    .prologue
    .line 197
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onResume()V

    .line 198
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v5

    if-eqz v5, :cond_0

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    new-instance v0, Lcom/wishabi/flipp/app/cy;

    iget-wide v2, p0, Lcom/wishabi/flipp/app/cx;->c:J

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/app/cy;-><init>(Lcom/wishabi/flipp/app/cx;JLjava/lang/String;Landroid/content/Context;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/cy;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 199
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 203
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 204
    const-string v0, "SAVE_STATE_ITEM_ID_KEY"

    iget-wide v2, p0, Lcom/wishabi/flipp/app/cx;->c:J

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 205
    const-string v0, "SAVE_STATE_ITEM_RATIO_KEY"

    iget v1, p0, Lcom/wishabi/flipp/app/cx;->e:F

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    .line 206
    return-void
.end method
