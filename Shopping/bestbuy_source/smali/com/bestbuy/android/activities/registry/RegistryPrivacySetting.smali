.class public Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/support/v4/app/Fragment;

.field private b:Z

.field private c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private i:Landroid/widget/Switch;

.field private j:Landroid/widget/Switch;

.field private k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private l:Z

.field private m:Z

.field private n:Ljava/lang/String;

.field private o:Landroid/os/Bundle;

.field private p:Landroid/widget/RelativeLayout;

.field private q:Z

.field private r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private t:Landroid/widget/ImageView;

.field private u:Landroid/widget/ImageView;

.field private v:I

.field private w:Ljava/lang/String;


# direct methods
.method public constructor <init>(I)V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    .line 52
    iput p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->v:I

    .line 53
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    .line 56
    iput p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->v:I

    .line 57
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->w:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public constructor <init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    .line 61
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->a:Landroid/support/v4/app/Fragment;

    .line 62
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b:Z

    .line 63
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 64
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->l:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->m:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    return p1
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method


# virtual methods
.method public b()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 224
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    if-eqz v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->l:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->m:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->w:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->w:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 232
    new-instance v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->w:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;-><init>(Ljava/lang/String;)V

    move-object v2, v0

    .line 237
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    const-string v1, "data"

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 238
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->setArguments(Landroid/os/Bundle;)V

    .line 239
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 240
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 241
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "RegistryAdditionalOptions"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 243
    :cond_1
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_2

    .line 244
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 246
    :cond_2
    return-void

    .line 234
    :cond_3
    new-instance v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;-><init>()V

    move-object v2, v0

    goto :goto_0
.end method

.method public c()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 249
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 250
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    .line 251
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    if-eqz v0, :cond_0

    .line 252
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    .line 257
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->l:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->m:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    const-string v1, "newPrivacySetting"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    const-string v1, "newIsKnot"

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->l:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    const-string v1, "newMyRegistry"

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->m:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->a:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->o:Landroid/os/Bundle;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v2, v3, v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 265
    return-void

    .line 254
    :cond_0
    const-string v0, "private"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    goto :goto_0
.end method

.method public d()V
    .locals 3

    .prologue
    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    const v1, 0x7f02011e

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setBackgroundResource(I)V

    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0063

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    const v1, 0x7f0200ad

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setBackgroundResource(I)V

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0b0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    .line 272
    return-void
.end method

.method public e()V
    .locals 3

    .prologue
    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    const v1, 0x7f02011e

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setBackgroundResource(I)V

    .line 276
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0063

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    .line 277
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    const v1, 0x7f0200ad

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setBackgroundResource(I)V

    .line 278
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0b0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    .line 279
    return-void
.end method

.method public f()V
    .locals 3

    .prologue
    const v2, 0x7f0b0047

    const/4 v1, 0x1

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setClickable(Z)V

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setClickable(Z)V

    .line 286
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 288
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 289
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 290
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 217
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b:Z

    if-eqz v0, :cond_0

    .line 218
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c()V

    .line 221
    :goto_0
    return-void

    .line 220
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b()V

    goto :goto_0
.end method

.method public h()V
    .locals 3

    .prologue
    const v2, 0x7f0b0022

    const/4 v1, 0x0

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 294
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setClickable(Z)V

    .line 296
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setClickable(Z)V

    .line 297
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 301
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 69
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    .line 70
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_0

    .line 72
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->k:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    :cond_0
    move-object v0, p1

    .line 74
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033d

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 75
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 76
    sget-object v0, Llu;->ax:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 305
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->t:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 306
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 307
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801d2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 309
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 310
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 313
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->u:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_1

    .line 314
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 315
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080381

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 317
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 318
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 320
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 83
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 99
    const v0, 0x7f0300e3

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 100
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->p:Landroid/widget/RelativeLayout;

    .line 101
    const v0, 0x7f0c037d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 102
    const v0, 0x7f0c037e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 103
    const v0, 0x7f0c0381

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    .line 104
    const v0, 0x7f0c0383

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    .line 105
    const v0, 0x7f0c0380

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 106
    const v0, 0x7f0c0382

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 107
    const v0, 0x7f0c037c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->t:Landroid/widget/ImageView;

    .line 108
    const v0, 0x7f0c037f

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->u:Landroid/widget/ImageView;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->t:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->u:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    if-eqz v0, :cond_2

    .line 113
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    .line 114
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d()V

    .line 119
    :goto_0
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->l:Z

    .line 120
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->m:Z

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$1;-><init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;-><init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->g:Lcom/bestbuy/android/bbyobjects/BBYButton;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;-><init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h:Lcom/bestbuy/android/bbyobjects/BBYButton;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$4;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$4;-><init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 179
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v2, "public"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 181
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    .line 182
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d()V

    .line 183
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->f()V

    .line 189
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v3}, Landroid/widget/Switch;->setChecked(Z)V

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    const-string v2, "Yes"

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    .line 196
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v3}, Landroid/widget/Switch;->setChecked(Z)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    const-string v2, "Yes"

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    .line 204
    :cond_1
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->p:Landroid/widget/RelativeLayout;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$5;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$5;-><init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    return-object v1

    .line 116
    :cond_2
    const-string v0, "private"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->n:Ljava/lang/String;

    .line 117
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->e()V

    goto/16 :goto_0

    .line 184
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v2, "private"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 185
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->q:Z

    .line 186
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->e()V

    .line 187
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->h()V

    goto :goto_1

    .line 193
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    invoke-virtual {v0, v4}, Landroid/widget/Switch;->setChecked(Z)V

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->i:Landroid/widget/Switch;

    const-string v2, "No"

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 200
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    invoke-virtual {v0, v4}, Landroid/widget/Switch;->setChecked(Z)V

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->j:Landroid/widget/Switch;

    const-string v2, "No"

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 87
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 88
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b:Z

    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 95
    :goto_0
    return-void

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033d

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
