.class public Lcom/bestbuy/android/activities/stores/StoresOutletFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/support/v4/app/Fragment;

.field private c:Z

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Landroid/view/View;

.field private j:Landroid/view/LayoutInflater;

.field private k:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->c:Z

    .line 45
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->c:Z

    .line 52
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->c:Z

    .line 53
    iput-object p2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->g:Ljava/lang/String;

    .line 54
    iput-object p3, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->h:Ljava/lang/String;

    .line 55
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoresOutletFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const v5, 0x7f080087

    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 85
    const v0, 0x7f08006c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const v0, 0x7f08012a

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 86
    :cond_0
    const/4 v0, 0x0

    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 88
    instance-of v2, v1, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v2, :cond_1

    move-object v0, v1

    .line 89
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->c()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    .line 91
    :cond_1
    invoke-static {p1, p2, v0}, Lkb;->a(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    .line 93
    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 130
    :cond_2
    :goto_0
    return-void

    .line 101
    :cond_3
    const v0, 0x7f08008d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 102
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 103
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08008a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 104
    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 105
    if-nez v1, :cond_4

    .line 106
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    const v2, 0x7f08004d

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 107
    if-nez v1, :cond_4

    .line 108
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 109
    const/16 v2, 0xa

    if-lt v1, v2, :cond_6

    .line 110
    new-instance v0, Lkt;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    sget-object v2, Lku;->b:Lku;

    invoke-direct {v0, v1, v2}, Lkt;-><init>(Landroid/content/Context;Lku;)V

    .line 111
    invoke-virtual {v0}, Lkt;->a()V

    .line 120
    :cond_4
    :goto_1
    const-string v0, "MdotWebFragment"

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v1

    .line 121
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 122
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->h:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->h:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    .line 123
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/stores?storeID="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->h:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 126
    :cond_5
    const-string v2, "mDotURL"

    invoke-virtual {v0, v2, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->b:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_0

    .line 113
    :cond_6
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 114
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    add-int/lit8 v1, v1, 0x1

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 115
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1
.end method

.method private a(Lmy;)V
    .locals 12

    .prologue
    const v11, 0x7f080077

    const/4 v5, 0x0

    .line 133
    if-eqz p1, :cond_7

    move v4, v5

    .line 134
    :goto_0
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v4, v0, :cond_7

    .line 135
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmx;

    .line 136
    invoke-virtual {v0}, Lmx;->b()Ljava/util/ArrayList;

    move-result-object v0

    .line 137
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmw;

    .line 138
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v11}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Pre-Owned"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 141
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->j:Landroid/view/LayoutInflater;

    const v2, 0x7f030109

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2, v3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 142
    const v2, 0x7f0c03e0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 143
    const v3, 0x7f0c03e1

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 144
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v0}, Lmw;->c()Ljava/lang/String;

    move-result-object v8

    const-string v9, "drawable"

    iget-object v10, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v7

    .line 145
    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 146
    invoke-virtual {v0}, Lmw;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 147
    const v2, 0x7f0c03e2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 148
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v3

    const v7, 0x7f08012a

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 149
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v7, 0x7f08034c

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 159
    :cond_1
    :goto_2
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 160
    new-instance v2, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;

    invoke-direct {v2, p0, v0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;-><init>(Lcom/bestbuy/android/activities/stores/StoresOutletFragment;Lmw;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 168
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 169
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 172
    const/4 v2, 0x3

    invoke-virtual {v1, v2, v5, v5, v5}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 173
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 174
    const v1, 0x7f0b0008

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 175
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_1

    .line 150
    :cond_2
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v3

    const v7, 0x7f08006c

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 151
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v7, 0x7f08034f

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_2

    .line 152
    :cond_3
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v3

    const-string v7, "Pre-Owned"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 153
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v7, 0x7f080350

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_2

    .line 154
    :cond_4
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v11}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 155
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v7, 0x7f080351

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 156
    :cond_5
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v3

    const v7, 0x7f08008d

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 157
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v7, 0x7f080353

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 134
    :cond_6
    add-int/lit8 v0, v4, 0x1

    move v4, v0

    goto/16 :goto_0

    .line 179
    :cond_7
    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    .line 61
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->b:Landroid/support/v4/app/Fragment;

    .line 62
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    .line 66
    const v0, 0x7f030108

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->j:Landroid/view/LayoutInflater;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    const v1, 0x7f0c03df

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->k:Landroid/widget/LinearLayout;

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->g:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->g:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    const v1, 0x7f0c011e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 71
    :cond_0
    new-instance v0, Lnc;

    invoke-direct {v0}, Lnc;-><init>()V

    .line 74
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->d:Landroid/app/Activity;

    sget-object v2, Lnb;->e:Ljava/lang/String;

    sget-object v3, Lnb;->d:[Ljava/lang/String;

    const/4 v4, 0x3

    aget-object v3, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lnc;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 75
    new-instance v1, Lmy;

    const-string v2, "StoresOutletItems"

    invoke-direct {v1, v0, v2}, Lmy;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a(Lmy;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->i:Landroid/view/View;

    return-object v0

    .line 77
    :catch_0
    move-exception v0

    .line 78
    sget-object v1, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error attempting to load & display deals cards: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
