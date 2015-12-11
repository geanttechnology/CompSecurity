.class Lcom/mixerbox/mixerbox3b/Onboarding$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field shouldMove:Z

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

.field final synthetic val$ivDot:Landroid/widget/ImageView;

.field final synthetic val$tvSkip:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding;Landroid/widget/TextView;Landroid/widget/ImageView;)V
    .locals 1

    .prologue
    .line 64
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$tvSkip:Landroid/widget/TextView;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$ivDot:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->shouldMove:Z

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0

    .prologue
    .line 69
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 15

    .prologue
    .line 72
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "arg0 = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", arg1 = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", arg2 = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p3

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 73
    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->shouldMove:Z

    if-eqz v1, :cond_4

    .line 74
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/Onboarding;->fm:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/Fragment;

    .line 75
    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v5

    .line 76
    const v1, 0x7f07008a

    invoke-virtual {v5, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 77
    const v2, 0x7f07008b

    invoke-virtual {v5, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 78
    const v3, 0x7f070089

    invoke-virtual {v5, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 79
    const v4, 0x7f07008c

    invoke-virtual {v5, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 81
    if-nez p1, :cond_0

    move/from16 v0, p2

    float-to-double v6, v0

    const-wide/high16 v8, 0x3fe0000000000000L    # 0.5

    cmpl-double v6, v6, v8

    if-gtz v6, :cond_1

    :cond_0
    const/4 v6, 0x1

    move/from16 v0, p1

    if-ne v0, v6, :cond_4

    move/from16 v0, p2

    float-to-double v6, v0

    const-wide/high16 v8, 0x3fe0000000000000L    # 0.5

    cmpg-double v6, v6, v8

    if-gez v6, :cond_4

    .line 82
    :cond_1
    const v6, 0x7f070088

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    .line 83
    invoke-virtual {v1}, Landroid/widget/ImageView;->getX()F

    move-result v6

    invoke-virtual {v1}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    add-float/2addr v6, v7

    .line 85
    const/4 v7, 0x1

    move/from16 v0, p1

    if-ne v0, v7, :cond_3

    .line 86
    invoke-virtual {v2}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    sub-float v7, v6, v7

    move/from16 v0, p3

    int-to-float v8, v0

    sub-float/2addr v7, v8

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setX(F)V

    .line 87
    move/from16 v0, p2

    float-to-double v7, v0

    const-wide/high16 v9, 0x3fe0000000000000L    # 0.5

    cmpg-double v7, v7, v9

    if-gez v7, :cond_2

    invoke-virtual {v1}, Landroid/widget/ImageView;->getX()F

    move-result v7

    float-to-double v7, v7

    invoke-virtual {v3}, Landroid/widget/ImageView;->getWidth()I

    move-result v9

    int-to-double v9, v9

    const-wide v11, 0x3ff3333333333333L    # 1.2

    mul-double/2addr v9, v11

    sub-double/2addr v7, v9

    double-to-int v7, v7

    add-int v7, v7, p3

    div-int/lit8 v8, p3, 0x4

    add-int/2addr v7, v8

    int-to-double v7, v7

    invoke-virtual {v1}, Landroid/widget/ImageView;->getWidth()I

    move-result v9

    int-to-float v9, v9

    invoke-virtual {v1}, Landroid/widget/ImageView;->getX()F

    move-result v10

    add-float/2addr v9, v10

    float-to-double v9, v9

    invoke-virtual {v3}, Landroid/widget/ImageView;->getWidth()I

    move-result v11

    int-to-double v11, v11

    const-wide v13, 0x3ff4cccccccccccdL    # 1.3

    mul-double/2addr v11, v13

    add-double/2addr v9, v11

    cmpg-double v7, v7, v9

    if-gez v7, :cond_2

    .line 88
    invoke-virtual {v1}, Landroid/widget/ImageView;->getX()F

    move-result v7

    float-to-double v7, v7

    invoke-virtual {v3}, Landroid/widget/ImageView;->getWidth()I

    move-result v9

    int-to-double v9, v9

    const-wide v11, 0x3ff3333333333333L    # 1.2

    mul-double/2addr v9, v11

    sub-double/2addr v7, v9

    double-to-int v7, v7

    add-int v7, v7, p3

    div-int/lit8 v8, p3, 0x4

    add-int/2addr v7, v8

    int-to-float v7, v7

    invoke-virtual {v3, v7}, Landroid/widget/ImageView;->setX(F)V

    .line 89
    :cond_2
    invoke-virtual {v4}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    int-to-float v7, v7

    sub-float v7, v6, v7

    div-int/lit8 v8, p3, 0x3

    int-to-float v8, v8

    sub-float/2addr v7, v8

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setX(F)V

    .line 91
    :cond_3
    if-nez p1, :cond_4

    .line 92
    invoke-virtual {v2}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    sub-float v7, v6, v7

    invoke-virtual {v5}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v8

    sub-int v8, v8, p3

    int-to-float v8, v8

    add-float/2addr v7, v8

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setX(F)V

    .line 93
    invoke-virtual {v1}, Landroid/widget/ImageView;->getX()F

    move-result v1

    float-to-double v1, v1

    invoke-virtual {v3}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    int-to-double v7, v7

    const-wide v9, 0x3ff3333333333333L    # 1.2

    mul-double/2addr v7, v9

    sub-double/2addr v1, v7

    double-to-int v1, v1

    invoke-virtual {v5}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v2

    sub-int v2, v2, p3

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setX(F)V

    .line 94
    invoke-virtual {v4}, Landroid/widget/ImageView;->getWidth()I

    move-result v1

    int-to-float v1, v1

    sub-float v1, v6, v1

    invoke-virtual {v5}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v2

    sub-int v2, v2, p3

    div-int/lit8 v2, v2, 0x3

    int-to-float v2, v2

    add-float/2addr v1, v2

    invoke-virtual {v4, v1}, Landroid/widget/ImageView;->setX(F)V

    .line 98
    :cond_4
    return-void
.end method

.method public onPageSelected(I)V
    .locals 11

    .prologue
    .line 101
    const/4 v0, 0x1

    if-ne p1, v0, :cond_3

    .line 102
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->shouldMove:Z

    .line 106
    :goto_0
    if-eqz p1, :cond_4

    .line 107
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->removeMessages(I)V

    .line 111
    :goto_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->fm:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 113
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v3

    .line 115
    const v0, 0x7f07008a

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 116
    const v1, 0x7f07008b

    invoke-virtual {v3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 117
    const v2, 0x7f070089

    invoke-virtual {v3, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 118
    const v4, 0x7f07008c

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 120
    invoke-virtual {v0}, Landroid/widget/ImageView;->getX()F

    move-result v4

    invoke-virtual {v0}, Landroid/widget/ImageView;->getWidth()I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    .line 121
    invoke-virtual {v0}, Landroid/widget/ImageView;->getX()F

    move-result v5

    float-to-double v5, v5

    invoke-virtual {v2}, Landroid/widget/ImageView;->getWidth()I

    move-result v7

    int-to-double v7, v7

    const-wide v9, 0x3ff3333333333333L    # 1.2

    mul-double/2addr v7, v9

    sub-double/2addr v5, v7

    double-to-int v5, v5

    int-to-float v5, v5

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setX(F)V

    .line 122
    invoke-virtual {v0}, Landroid/widget/ImageView;->getY()F

    move-result v5

    invoke-virtual {v1}, Landroid/widget/ImageView;->getHeight()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    int-to-float v6, v6

    sub-float/2addr v5, v6

    invoke-virtual {v1, v5}, Landroid/widget/ImageView;->setY(F)V

    .line 123
    invoke-virtual {v1}, Landroid/widget/ImageView;->getWidth()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    sub-float v5, v4, v5

    invoke-virtual {v1, v5}, Landroid/widget/ImageView;->setX(F)V

    .line 124
    invoke-virtual {v3}, Landroid/widget/ImageView;->getWidth()I

    move-result v5

    int-to-float v5, v5

    sub-float/2addr v4, v5

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setX(F)V

    .line 125
    invoke-virtual {v0}, Landroid/widget/ImageView;->getY()F

    move-result v4

    invoke-virtual {v0}, Landroid/widget/ImageView;->getHeight()I

    move-result v0

    int-to-float v0, v0

    add-float/2addr v0, v4

    invoke-virtual {v3}, Landroid/widget/ImageView;->getHeight()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    sub-float/2addr v0, v4

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setY(F)V

    .line 126
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 127
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 128
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 129
    :cond_0
    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 132
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->fm:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 133
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v3

    .line 134
    const v0, 0x7f07007d

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 135
    const v1, 0x7f070080

    invoke-virtual {v3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 136
    const v2, 0x7f070083

    invoke-virtual {v3, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 137
    const v4, 0x7f070086

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 138
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    const v5, 0x7f040005

    invoke-static {v4, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v4

    .line 139
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    const v6, 0x7f040005

    invoke-static {v5, v6}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v5

    .line 140
    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    const v7, 0x7f040005

    invoke-static {v6, v7}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v6

    .line 141
    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    const v8, 0x7f040005

    invoke-static {v7, v8}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v7

    .line 142
    const/4 v8, 0x4

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 143
    const/4 v8, 0x4

    invoke-virtual {v1, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 144
    const/4 v8, 0x4

    invoke-virtual {v2, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 145
    const/4 v8, 0x4

    invoke-virtual {v3, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 147
    const/4 v8, 0x1

    invoke-virtual {v4, v8}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 148
    new-instance v8, Lcom/mixerbox/mixerbox3b/Onboarding$1$1;

    invoke-direct {v8, p0, v0, v1, v5}, Lcom/mixerbox/mixerbox3b/Onboarding$1$1;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/view/animation/Animation;)V

    invoke-virtual {v4, v8}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 161
    const/4 v8, 0x1

    invoke-virtual {v5, v8}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 162
    new-instance v8, Lcom/mixerbox/mixerbox3b/Onboarding$1$2;

    invoke-direct {v8, p0, v1, v2, v6}, Lcom/mixerbox/mixerbox3b/Onboarding$1$2;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/view/animation/Animation;)V

    invoke-virtual {v5, v8}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 175
    const/4 v1, 0x1

    invoke-virtual {v6, v1}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 176
    new-instance v1, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;

    invoke-direct {v1, p0, v2, v3, v7}, Lcom/mixerbox/mixerbox3b/Onboarding$1$3;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/view/animation/Animation;)V

    invoke-virtual {v6, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 189
    const/4 v1, 0x1

    invoke-virtual {v7, v1}, Landroid/view/animation/Animation;->setRepeatCount(I)V

    .line 190
    new-instance v1, Lcom/mixerbox/mixerbox3b/Onboarding$1$4;

    invoke-direct {v1, p0, v3}, Lcom/mixerbox/mixerbox3b/Onboarding$1$4;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding$1;Landroid/widget/ImageView;)V

    invoke-virtual {v7, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 202
    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 204
    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_5

    .line 205
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$tvSkip:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 209
    :goto_2
    if-nez p1, :cond_6

    .line 210
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$ivDot:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/Onboarding;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200d8

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 213
    :cond_2
    :goto_3
    return-void

    .line 104
    :cond_3
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->shouldMove:Z

    goto/16 :goto_0

    .line 109
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    const/4 v1, 0x1

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_1

    .line 207
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$tvSkip:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2

    .line 211
    :cond_6
    const/4 v0, 0x1

    if-ne p1, v0, :cond_2

    .line 212
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->val$ivDot:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$1;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/Onboarding;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200d9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_3
.end method
