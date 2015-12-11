.class public Lcom/wishabi/flipp/app/bx;
.super Lcom/wishabi/flipp/app/dl;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private c:Landroid/widget/ScrollView;

.field private d:Landroid/widget/ProgressBar;

.field private e:Landroid/widget/LinearLayout;

.field private f:Landroid/widget/TextView;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/TextView;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/TextView;

.field private k:Landroid/widget/TextView;

.field private l:Landroid/widget/TextView;

.field private m:I

.field private n:Ljava/lang/String;

.field private o:Z

.field private p:Z

.field private q:Lcom/wishabi/flipp/content/FlyerInfo;

.field private r:Ljava/lang/String;

.field private s:Z

.field private t:Z

.field private u:Lcom/wishabi/flipp/b/ab;

.field private v:Lcom/wishabi/flipp/b/aa;

.field private w:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/wishabi/flipp/app/bx;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/bx;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/wishabi/flipp/app/dl;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bx;)I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/wishabi/flipp/app/bx;->m:I

    return v0
.end method

.method public static a(ILjava/lang/String;ZZ)Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 67
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 68
    const-string v1, "flyer_id"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 69
    const-string v1, "merchant_name"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    const-string v1, "web_indexed"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 71
    const-string v1, "no_prices"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 72
    return-object v0
.end method

.method public static a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/bx;
    .locals 1

    .prologue
    .line 82
    new-instance v0, Lcom/wishabi/flipp/app/bx;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/bx;-><init>()V

    .line 83
    invoke-virtual {v0, p0}, Lcom/wishabi/flipp/app/bx;->setArguments(Landroid/os/Bundle;)V

    .line 84
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bx;Lcom/wishabi/flipp/content/FlyerInfo;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/content/FlyerInfo;)V

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bx;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/bx;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Lcom/wishabi/flipp/content/FlyerInfo;)V
    .locals 9

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 216
    iput-object p1, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    .line 219
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v4

    .line 221
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 222
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v7, :cond_5

    const v0, 0x7f0e0121

    .line 226
    :goto_0
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "fr"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 227
    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v1

    .line 232
    :goto_1
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object v1, v2, v8

    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->r:Ljava/lang/String;

    aput-object v1, v2, v7

    invoke-virtual {p0, v0, v2}, Lcom/wishabi/flipp/app/bx;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 234
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v1, v0, Lcom/wishabi/flipp/content/FlyerInfo;->a:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bx;->e:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/wishabi/flipp/app/bx;->f:Landroid/widget/TextView;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/app/bx;->a(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/view/LayoutInflater;Ljava/lang/String;)V

    .line 237
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_b

    move v6, v7

    .line 240
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 241
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v7, :cond_7

    const v0, 0x7f0e00e3

    .line 244
    :goto_3
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/bx;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v1, v0, Lcom/wishabi/flipp/content/FlyerInfo;->b:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bx;->g:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/wishabi/flipp/app/bx;->h:Landroid/widget/TextView;

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/app/bx;->a(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/view/LayoutInflater;Ljava/lang/String;)V

    .line 249
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v0

    if-lez v0, :cond_0

    move v6, v7

    .line 252
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    iget-object v0, v0, Lcom/wishabi/flipp/content/FlyerInfo;->c:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 253
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->i:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/wishabi/flipp/app/ca;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/ca;-><init>(Lcom/wishabi/flipp/app/bx;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 275
    :cond_1
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->o:Z

    if-eqz v0, :cond_3

    .line 276
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 277
    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bx;->p:Z

    if-eqz v1, :cond_2

    .line 278
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0e0090

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 279
    const-string v1, "\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 281
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0e0091

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 282
    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->j:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 283
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 286
    :cond_3
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->s:Z

    if-nez v0, :cond_9

    .line 287
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 288
    if-eqz v6, :cond_8

    .line 289
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    const v1, 0x7f0e00d0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 298
    :cond_4
    :goto_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->f:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->h:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->j:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_a

    .line 303
    const v0, 0x7f0e00d2

    new-array v1, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/bx;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/bx;->a(Ljava/lang/String;)V

    .line 321
    :goto_5
    return-void

    .line 222
    :cond_5
    const v0, 0x7f0e0122

    goto/16 :goto_0

    .line 229
    :cond_6
    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_1

    .line 241
    :cond_7
    const v0, 0x7f0e00e4

    goto/16 :goto_3

    .line 291
    :cond_8
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    const v1, 0x7f0e00cf

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_4

    .line 293
    :cond_9
    if-eqz v6, :cond_4

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->t:Z

    if-nez v0, :cond_4

    .line 294
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 295
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    const v1, 0x7f0e00d1

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/bx;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    .line 308
    :cond_a
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x10e0000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 311
    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->c:Landroid/widget/ScrollView;

    invoke-virtual {v1, v8}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 312
    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->c:Landroid/widget/ScrollView;

    invoke-virtual {v1}, Landroid/widget/ScrollView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    .line 314
    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    invoke-virtual {v1}, Landroid/widget/ProgressBar;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    int-to-long v2, v0

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/wishabi/flipp/app/cb;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/cb;-><init>(Lcom/wishabi/flipp/app/bx;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    goto :goto_5

    :cond_b
    move v6, v8

    goto/16 :goto_2
.end method

.method private a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 414
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->k:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 415
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->k:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 416
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 417
    return-void
.end method

.method private a(Ljava/util/ArrayList;Landroid/view/ViewGroup;Landroid/widget/TextView;Landroid/view/LayoutInflater;Ljava/lang/String;)V
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/bb;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Landroid/widget/TextView;",
            "Landroid/view/LayoutInflater;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 326
    const/4 v2, 0x0

    .line 328
    invoke-virtual/range {p1 .. p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    move v3, v2

    :cond_0
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/bb;

    .line 329
    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->e:Ljava/lang/String;

    if-eqz v4, :cond_2

    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->e:Ljava/lang/String;

    move-object v7, v4

    .line 330
    :goto_1
    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->a:Ljava/lang/String;

    if-eqz v4, :cond_3

    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->a:Ljava/lang/String;

    move-object v8, v4

    .line 331
    :goto_2
    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->b:Ljava/lang/String;

    if-eqz v4, :cond_4

    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->b:Ljava/lang/String;

    move-object v9, v4

    .line 332
    :goto_3
    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->c:Ljava/lang/String;

    if-eqz v4, :cond_5

    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->c:Ljava/lang/String;

    move-object v10, v4

    .line 333
    :goto_4
    iget-object v4, v2, Lcom/wishabi/flipp/content/bb;->d:Ljava/lang/String;

    if-eqz v4, :cond_6

    iget-object v2, v2, Lcom/wishabi/flipp/content/bb;->d:Ljava/lang/String;

    move-object v11, v2

    .line 335
    :goto_5
    const-string v2, ""

    invoke-virtual {v8, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, ""

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 336
    const/4 v6, 0x1

    .line 340
    const v2, 0x7f03002d

    const/4 v3, 0x1

    move-object/from16 v0, p4

    move-object/from16 v1, p2

    invoke-virtual {v0, v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    .line 342
    const v2, 0x7f0b00be

    invoke-virtual {v13, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 343
    const v3, 0x7f0b00bf

    invoke-virtual {v13, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 344
    const v4, 0x7f0b00c0

    invoke-virtual {v13, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 345
    const v5, 0x7f0b00c1

    invoke-virtual {v13, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/FrameLayout;

    .line 347
    const/16 v14, 0x8

    invoke-virtual {v5, v14}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 349
    const-string v5, ""

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    iget-object v7, p0, Lcom/wishabi/flipp/app/bx;->n:Ljava/lang/String;

    :cond_1
    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 350
    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 351
    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 353
    const-string v2, "%s, %s, %s, %s"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v8, v3, v4

    const/4 v4, 0x1

    aput-object v9, v3, v4

    const/4 v4, 0x2

    aput-object v10, v3, v4

    const/4 v4, 0x3

    aput-object v11, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 357
    :try_start_0
    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 362
    :goto_6
    new-instance v3, Lcom/wishabi/flipp/app/cc;

    invoke-direct {v3, p0, v2}, Lcom/wishabi/flipp/app/cc;-><init>(Lcom/wishabi/flipp/app/bx;Ljava/lang/String;)V

    invoke-virtual {v13, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move v3, v6

    .line 375
    goto/16 :goto_0

    .line 329
    :cond_2
    const-string v4, ""

    move-object v7, v4

    goto/16 :goto_1

    .line 330
    :cond_3
    const-string v4, ""

    move-object v8, v4

    goto/16 :goto_2

    .line 331
    :cond_4
    const-string v4, ""

    move-object v9, v4

    goto/16 :goto_3

    .line 332
    :cond_5
    const-string v4, ""

    move-object v10, v4

    goto/16 :goto_4

    .line 333
    :cond_6
    const-string v2, ""

    move-object v11, v2

    goto/16 :goto_5

    .line 359
    :catch_0
    move-exception v3

    const-string v3, "Can\'t URL encode address: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    goto :goto_6

    .line 377
    :cond_7
    if-eqz v3, :cond_8

    .line 378
    const/4 v2, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 379
    move-object/from16 v0, p3

    move-object/from16 v1, p5

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 380
    const/4 v2, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 382
    :cond_8
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bx;Z)Z
    .locals 0

    .prologue
    .line 35
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/bx;->t:Z

    return p1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/bx;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->r:Ljava/lang/String;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->c:Landroid/widget/ScrollView;

    invoke-virtual {v0, v2}, Landroid/widget/ScrollView;->setVisibility(I)V

    .line 156
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->c:Landroid/widget/ScrollView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->setAlpha(F)V

    .line 157
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 158
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setAlpha(F)V

    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->f:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 161
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 162
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 163
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 164
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 165
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 167
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->j:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->k:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 169
    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/bx;Z)Z
    .locals 0

    .prologue
    .line 35
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/bx;->s:Z

    return p1
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/b/ab;
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    return-object v0
.end method

.method private c()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 402
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    if-eqz v0, :cond_0

    .line 403
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/ab;->a()V

    .line 404
    iput-object v2, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    .line 407
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->v:Lcom/wishabi/flipp/b/aa;

    if-eqz v0, :cond_1

    .line 408
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->v:Lcom/wishabi/flipp/b/aa;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/aa;->cancel(Z)Z

    .line 409
    iput-object v2, p0, Lcom/wishabi/flipp/app/bx;->v:Lcom/wishabi/flipp/b/aa;

    .line 411
    :cond_1
    return-void
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/b/aa;
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->v:Lcom/wishabi/flipp/b/aa;

    return-object v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/bx;)Lcom/wishabi/flipp/content/FlyerInfo;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    return-object v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/bx;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic g(Lcom/wishabi/flipp/app/bx;)Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->w:Z

    return v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/app/bx;)Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->w:Z

    return v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 89
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onCreate(Landroid/os/Bundle;)V

    .line 90
    if-eqz p1, :cond_1

    .line 93
    :goto_0
    if-eqz p1, :cond_0

    .line 94
    const-string v0, "flyer_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bx;->m:I

    .line 95
    const-string v0, "merchant_name"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->n:Ljava/lang/String;

    .line 96
    const-string v0, "web_indexed"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->o:Z

    .line 97
    const-string v0, "no_prices"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->p:Z

    .line 98
    const-string v0, "location_services_on"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->s:Z

    .line 99
    const-string v0, "found_lat_lon"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->t:Z

    .line 100
    const-string v0, "flyer_info"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/FlyerInfo;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    .line 103
    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->r:Ljava/lang/String;

    .line 104
    return-void

    .line 90
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getArguments()Landroid/os/Bundle;

    move-result-object p1

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 110
    const v0, 0x7f03002c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 111
    if-nez v1, :cond_0

    .line 112
    const/4 v0, 0x0

    .line 128
    :goto_0
    return-object v0

    .line 114
    :cond_0
    const v0, 0x7f0b00b4

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->c:Landroid/widget/ScrollView;

    .line 115
    const v0, 0x7f0b00bc

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->d:Landroid/widget/ProgressBar;

    .line 116
    const v0, 0x7f0b00b5

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->l:Landroid/widget/TextView;

    .line 117
    const v0, 0x7f0b00b7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->e:Landroid/widget/LinearLayout;

    .line 119
    const v0, 0x7f0b00b6

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->f:Landroid/widget/TextView;

    .line 120
    const v0, 0x7f0b00b9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->g:Landroid/widget/LinearLayout;

    .line 121
    const v0, 0x7f0b00b8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->h:Landroid/widget/TextView;

    .line 122
    const v0, 0x7f0b00ba

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->i:Landroid/widget/LinearLayout;

    .line 124
    const v0, 0x7f0b00bb

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->j:Landroid/widget/TextView;

    .line 126
    const v0, 0x7f0b00bd

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->k:Landroid/widget/TextView;

    move-object v0, v1

    .line 128
    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 421
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onResume()V

    .line 422
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bx;->w:Z

    .line 423
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 144
    invoke-super {p0, p1}, Lcom/wishabi/flipp/app/dl;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 145
    const-string v0, "flyer_id"

    iget v1, p0, Lcom/wishabi/flipp/app/bx;->m:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 146
    const-string v0, "merchant_name"

    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->n:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    const-string v0, "web_indexed"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bx;->o:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 148
    const-string v0, "no_prices"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bx;->p:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 149
    const-string v0, "location_services_on"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bx;->s:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 150
    const-string v0, "found_lat_lon"

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bx;->t:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 151
    const-string v0, "flyer_info"

    iget-object v1, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 152
    return-void
.end method

.method public onStart()V
    .locals 4

    .prologue
    .line 386
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onStart()V

    .line 388
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    if-nez v0, :cond_1

    .line 389
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bx;->b()V

    .line 390
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->r:Ljava/lang/String;

    if-nez v0, :cond_2

    :cond_0
    const v0, 0x7f0e00ce

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/wishabi/flipp/util/q;->a()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/bx;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/bx;->a(Ljava/lang/String;)V

    .line 392
    :cond_1
    :goto_0
    return-void

    .line 390
    :cond_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bx;->c()V

    new-instance v0, Lcom/wishabi/flipp/app/by;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/wishabi/flipp/app/by;-><init>(Lcom/wishabi/flipp/app/bx;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->u:Lcom/wishabi/flipp/b/ab;

    const-wide/32 v2, 0x927c0

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/b/ab;->a(J)V

    goto :goto_0
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 396
    invoke-super {p0}, Lcom/wishabi/flipp/app/dl;->onStop()V

    .line 397
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bx;->c()V

    .line 398
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 134
    const v0, 0x7f0e00bd

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/bx;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/bx;->b(Ljava/lang/String;)V

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    if-eqz v0, :cond_0

    .line 137
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bx;->b()V

    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/app/bx;->q:Lcom/wishabi/flipp/content/FlyerInfo;

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/bx;->a(Lcom/wishabi/flipp/content/FlyerInfo;)V

    .line 140
    :cond_0
    return-void
.end method
