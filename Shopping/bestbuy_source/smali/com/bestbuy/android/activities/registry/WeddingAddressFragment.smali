.class public Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private B:Landroid/widget/LinearLayout;

.field private C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private D:I

.field private E:Ljava/lang/String;

.field private F:Ljava/lang/String;

.field private G:Z

.field private H:Z

.field private I:Ljava/lang/String;

.field private J:Landroid/text/InputFilter;

.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/EditText;

.field private i:Landroid/widget/Spinner;

.field private j:Landroid/widget/EditText;

.field private k:Landroid/widget/EditText;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private n:Landroid/os/Bundle;

.field private o:Z

.field private p:Lcu;

.field private q:Landroid/widget/ImageButton;

.field private r:Z

.field private s:Z

.field private t:Z

.field private u:Z

.field private v:Z

.field private w:Z

.field private x:Z

.field private y:Landroid/support/v4/app/Fragment;

.field private z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 94
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->r:Z

    .line 64
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->s:Z

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->t:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->u:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->v:Z

    .line 68
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->w:Z

    .line 69
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->x:Z

    .line 81
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->G:Z

    .line 82
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->H:Z

    .line 83
    const-string v0, "()-/*#,.+;NPWpw;><?_$%^&@!"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->I:Ljava/lang/String;

    .line 442
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->J:Landroid/text/InputFilter;

    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->y:Landroid/support/v4/app/Fragment;

    .line 96
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->o:Z

    .line 97
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 98
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 85
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->r:Z

    .line 64
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->s:Z

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->t:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->u:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->v:Z

    .line 68
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->w:Z

    .line 69
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->x:Z

    .line 81
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->G:Z

    .line 82
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->H:Z

    .line 83
    const-string v0, "()-/*#,.+;NPWpw;><?_$%^&@!"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->I:Ljava/lang/String;

    .line 442
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->J:Landroid/text/InputFilter;

    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 87
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 89
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->r:Z

    .line 64
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->s:Z

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->t:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->u:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->v:Z

    .line 68
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->w:Z

    .line 69
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->x:Z

    .line 81
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->G:Z

    .line 82
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->H:Z

    .line 83
    const-string v0, "()-/*#,.+;NPWpw;><?_$%^&@!"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->I:Ljava/lang/String;

    .line 442
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->J:Landroid/text/InputFilter;

    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 91
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->F:Ljava/lang/String;

    .line 92
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->G:Z

    return p1
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->s:Z

    return v0
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->r:Z

    return p1
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->t:Z

    return v0
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->H:Z

    return p1
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->u:Z

    return v0
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->s:Z

    return p1
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->v:Z

    return v0
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->t:Z

    return p1
.end method

.method public static synthetic f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->x:Z

    return v0
.end method

.method public static synthetic f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->u:Z

    return p1
.end method

.method public static synthetic g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->w:Z

    return v0
.end method

.method public static synthetic g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->v:Z

    return p1
.end method

.method public static synthetic h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->G:Z

    return v0
.end method

.method public static synthetic h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->w:Z

    return p1
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->I:Ljava/lang/String;

    return-object v0
.end method

.method public static synthetic i(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->x:Z

    return p1
.end method


# virtual methods
.method public a(Landroid/location/Address;)V
    .locals 0

    .prologue
    .line 339
    invoke-virtual {p1}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    .line 340
    invoke-virtual {p1}, Landroid/location/Address;->getCountryName()Ljava/lang/String;

    .line 341
    return-void
.end method

.method public b()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    .line 245
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 252
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 253
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 254
    const-string v8, "\\D"

    const-string v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 256
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    if-eqz v8, :cond_2

    .line 257
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v1, v8, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->addressFirstName:Ljava/lang/String;

    .line 258
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->addressLastName:Ljava/lang/String;

    .line 259
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->addressLine1:Ljava/lang/String;

    .line 260
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->addressLine2:Ljava/lang/String;

    .line 261
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v5, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->zipCode:Ljava/lang/String;

    .line 262
    if-eqz v0, :cond_5

    const-string v1, "Select"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "Select a state"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 263
    :cond_0
    const-string v0, ""

    .line 267
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->state:Ljava/lang/String;

    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v6, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->city:Ljava/lang/String;

    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v7, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->phone:Ljava/lang/String;

    .line 271
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->D:I

    .line 281
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->F:Ljava/lang/String;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->F:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_6

    .line 282
    new-instance v0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->D:I

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->F:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;-><init>(ILjava/lang/String;)V

    move-object v2, v0

    .line 286
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v1, "data"

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->setArguments(Landroid/os/Bundle;)V

    .line 288
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 289
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_3

    move-object v0, v1

    .line 290
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "RegistryPrivacySetting"

    invoke-virtual {v0, v2, v10, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 292
    :cond_3
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_4

    .line 293
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v10}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 295
    :cond_4
    return-void

    .line 264
    :cond_5
    if-eqz v0, :cond_1

    .line 265
    const/4 v1, 0x0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 284
    :cond_6
    new-instance v0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->D:I

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;-><init>(I)V

    move-object v2, v0

    goto :goto_1
.end method

.method public c()V
    .locals 10

    .prologue
    .line 298
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 305
    if-eqz v0, :cond_1

    const-string v6, "Select"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    const-string v6, "Select a state"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 308
    :cond_0
    const-string v0, ""

    .line 310
    :cond_1
    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 311
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 312
    new-instance v8, Landroid/os/Bundle;

    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    iput-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    .line 313
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newFirstName"

    invoke-virtual {v8, v9, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newLastName"

    invoke-virtual {v8, v9, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 315
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newAddressLine1"

    invoke-virtual {v8, v9, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newAddressLine2"

    invoke-virtual {v8, v9, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 317
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newZip"

    invoke-virtual {v8, v9, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newState"

    invoke-virtual {v8, v9, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 319
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newCity"

    invoke-virtual {v8, v9, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    const-string v9, "newPhoneNumber"

    invoke-virtual {v8, v9, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v8, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressFirstName(Ljava/lang/String;)V

    .line 322
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLastName(Ljava/lang/String;)V

    .line 323
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine1(Ljava/lang/String;)V

    .line 324
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine2(Ljava/lang/String;)V

    .line 325
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCity(Ljava/lang/String;)V

    .line 326
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setState(Ljava/lang/String;)V

    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setZipCode(Ljava/lang/String;)V

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPhone(Ljava/lang/String;)V

    .line 329
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 330
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->D:I

    .line 333
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->y:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->n:Landroid/os/Bundle;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    const/4 v3, 0x1

    iget v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->D:I

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V

    .line 334
    sget-object v0, Llu;->aw:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 336
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 236
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->o:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->H:Z

    if-eqz v0, :cond_0

    .line 237
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c()V

    .line 239
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->r:Z

    if-eqz v0, :cond_1

    .line 240
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b()V

    .line 242
    :cond_1
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 102
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 103
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    .line 104
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 105
    if-eqz v0, :cond_0

    .line 106
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    :cond_0
    move-object v0, p1

    .line 108
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 109
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 110
    check-cast p1, Lcu;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->p:Lcu;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->p:Lcu;

    invoke-interface {v0}, Lcu;->onCreateRegistryFragmentLaunch()V

    .line 112
    sget-object v0, Llu;->aw:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 113
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 432
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->q:Landroid/widget/ImageButton;

    if-ne p1, v0, :cond_0

    .line 433
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 434
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 440
    :cond_0
    :goto_0
    return-void

    .line 436
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 437
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801ea

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 117
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 119
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 12

    .prologue
    const/4 v11, 0x2

    const/4 v1, 0x0

    .line 135
    const v0, 0x7f030112

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v3, 0x10

    invoke-virtual {v0, v3}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 139
    const v0, 0x7f0c0076

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->B:Landroid/widget/LinearLayout;

    .line 140
    const v0, 0x7f0c03f1

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 141
    const v0, 0x7f0c00a7

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    .line 142
    const v0, 0x7f0c00a8

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    .line 143
    const v0, 0x7f0c03e8

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    .line 144
    const v0, 0x7f0c03e9

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g:Landroid/widget/EditText;

    .line 145
    const v0, 0x7f0c03ea

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    .line 146
    const v0, 0x7f0c0377

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    .line 147
    const v0, 0x7f0c0374

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    .line 148
    const v0, 0x7f0c03eb

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setInputType(I)V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    new-array v3, v11, [Landroid/text/InputFilter;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->J:Landroid/text/InputFilter;

    aput-object v4, v3, v1

    const/4 v4, 0x1

    new-instance v5, Landroid/text/InputFilter$LengthFilter;

    const/16 v6, 0xe

    invoke-direct {v5, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v5, v3, v4

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    new-instance v3, Landroid/telephony/PhoneNumberFormattingTextWatcher;

    invoke-direct {v3}, Landroid/telephony/PhoneNumberFormattingTextWatcher;-><init>()V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    new-instance v3, Ldb;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    invoke-direct {v3, p0, v4}, Ldb;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 158
    const v0, 0x7f0c03ec

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->q:Landroid/widget/ImageButton;

    .line 159
    const v0, 0x7f0c03ed

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->q:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->B:Landroid/widget/LinearLayout;

    new-instance v3, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$1;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    new-instance v3, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    if-eqz v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->A:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 199
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->o:Z

    if-eqz v0, :cond_2

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->z:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getRecipient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v0

    .line 202
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 203
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v3

    .line 204
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v4

    .line 205
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v5

    .line 206
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v6

    .line 207
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v7

    .line 208
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v8

    .line 209
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v9

    .line 210
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v0

    .line 211
    iget-object v10, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v10, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 212
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b:Landroid/widget/EditText;

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 213
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 214
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g:Landroid/widget/EditText;

    invoke-virtual {v3, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 215
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v3, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 216
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h:Landroid/widget/EditText;

    invoke-virtual {v3, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 217
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v3, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 218
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v0

    .line 219
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 220
    invoke-virtual {v8, v1, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 221
    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->E:Ljava/lang/String;

    .line 223
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v3, 0x7f0a0000

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    move v0, v1

    .line 224
    :goto_0
    array-length v1, v3

    if-ge v0, v1, :cond_2

    .line 225
    aget-object v1, v3, v0

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->E:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 226
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v1, v0}, Landroid/widget/Spinner;->setSelection(I)V

    .line 231
    :cond_2
    return-object v2

    .line 224
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 455
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 456
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 457
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 123
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 124
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->o:Z

    if-eqz v0, :cond_0

    .line 125
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08017e

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 131
    :goto_0
    return-void

    .line 128
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
