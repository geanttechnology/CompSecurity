.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private e:Landroid/widget/RelativeLayout;

.field private f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Lnb;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/lang/String;

.field private t:Ljava/lang/String;

.field private u:Landroid/app/Dialog;

.field private v:Landroid/widget/ImageView;

.field private w:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 140
    invoke-static {p1}, Lne;->b(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 141
    const-string v1, ""

    .line 142
    invoke-static {}, Lne;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 143
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Today, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "EEE, MMM dd"

    invoke-static {v2, v0}, Lne;->a(Ljava/lang/String;Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 147
    :goto_0
    return-object v0

    .line 145
    :cond_0
    const-string v1, "EEE, MMM dd"

    invoke-static {v1, v0}, Lne;->a(Ljava/lang/String;Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private a()V
    .locals 4

    .prologue
    .line 110
    const v0, 0x7f0c0022

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 111
    const v0, 0x7f0c0024

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 112
    const v0, 0x7f0c0025

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 113
    const v0, 0x7f0c0026

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 114
    const v0, 0x7f0c0027

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 116
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 117
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 119
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080053

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->n:Ljava/lang/String;

    .line 120
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080054

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->o:Ljava/lang/String;

    .line 121
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->p:Ljava/lang/String;

    .line 122
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080140

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->q:Ljava/lang/String;

    .line 124
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->n:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->o:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 126
    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080050

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Best Buy Mobile - "

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-static {v1}, Lnr;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 137
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->b()V

    return-void
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 151
    const-string v0, ""

    .line 152
    const-string v1, "am"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "pm"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 153
    :cond_0
    const-string v0, "am"

    const-string v1, " AM"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "pm"

    const-string v2, " PM"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 155
    :cond_1
    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    .line 159
    new-instance v0, Landroid/app/Dialog;

    invoke-direct {v0, p0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/Window;->requestFeature(I)Z

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    const v1, 0x7f030015

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->setContentView(I)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    const v1, 0x7f0c006a

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    const v1, 0x7f0c006b

    invoke-virtual {v0, v1}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const v8, 0x7f080143

    const v7, 0x7f080141

    const v6, 0x7f0800b9

    const/4 v5, 0x1

    const/high16 v4, 0x4000000

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_1

    .line 211
    sget-object v0, Llu;->aS:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 212
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 213
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    .line 214
    new-instance v0, Lhv;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->m:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->q:Ljava/lang/String;

    iget-object v4, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->p:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lhv;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhv;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 250
    :cond_0
    :goto_0
    return-void

    .line 215
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_2

    .line 216
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 217
    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 218
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 219
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 220
    const-string v2, "blueassist_update"

    invoke-virtual {v1, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 221
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->p:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->r:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->s:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080144

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->t:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 226
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 227
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_3

    .line 228
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 229
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 230
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 231
    invoke-virtual {v1, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 232
    const-string v2, "blueassist_update"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 233
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->p:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 234
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->r:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->s:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080144

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->t:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080053

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->n:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080054

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->o:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 240
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 241
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->w:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_4

    .line 242
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->finish()V

    goto/16 :goto_0

    .line 243
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->v:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 244
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 245
    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 246
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->startActivity(Landroid/content/Intent;)V

    .line 247
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->finish()V

    .line 248
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->overridePendingTransition(II)V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 65
    const/high16 v0, 0x7f030000

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->setContentView(I)V

    .line 67
    sget-object v0, Llu;->aR:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 69
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->g:Lnb;

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->g:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 71
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->a()V

    .line 74
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 75
    if-eqz v0, :cond_0

    .line 76
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080141

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->r:Ljava/lang/String;

    .line 77
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080143

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->s:Ljava/lang/String;

    .line 78
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080144

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->t:Ljava/lang/String;

    .line 81
    :cond_0
    const v0, 0x7f0c0029

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    const v0, 0x7f0c0020

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->e:Landroid/widget/RelativeLayout;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->e:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015e

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->e:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015f

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 100
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f08021f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    const v1, 0x7f080231

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 102
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->v:Landroid/widget/ImageView;

    .line 103
    const v0, 0x7f0c0068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->w:Landroid/widget/ImageView;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->w:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->v:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 254
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;->u:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 258
    :cond_0
    return-void
.end method
