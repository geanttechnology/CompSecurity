.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Ljava/lang/String;

.field private B:Ljava/lang/String;

.field private C:Landroid/text/InputFilter;

.field private D:Landroid/text/InputFilter;

.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private d:Landroid/widget/EditText;

.field private e:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private f:Landroid/widget/RelativeLayout;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private h:Lnb;

.field private i:Z

.field private j:Z

.field private k:Z

.field private l:Z

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/lang/String;

.field private t:Z

.field private u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private v:Ljava/lang/String;

.field private w:Landroid/widget/ImageView;

.field private x:Landroid/widget/ImageView;

.field private y:Ljava/util/regex/Pattern;

.field private z:Ljava/util/regex/Matcher;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 38
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 46
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->i:Z

    .line 47
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->j:Z

    .line 48
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->k:Z

    .line 49
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->l:Z

    .line 65
    const-string v0, "*\"\':;!?)(+-&%$#@\\\u00a9\u00ae\u2122\u2105[]}{=\u00b0^\u00a5\u20ac\u00a2\u00a3\u2206\u00b6\u00d7\u00f7\u03c0\u221a\u2022|`~.,<>/0123456789"

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->A:Ljava/lang/String;

    .line 66
    const-string v0, "*\"\':;!?)(+-&%$#@\\\u00a9\u00ae\u2122\u2105[]}{=\u00b0^\u00a5\u20ac\u00a2\u00a3\u2206\u00b6\u00d7\u00f7\u03c0\u221a\u2022|`~.,<>/N"

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->B:Ljava/lang/String;

    .line 286
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$2;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->C:Landroid/text/InputFilter;

    .line 297
    new-instance v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$3;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->D:Landroid/text/InputFilter;

    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYButton;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z
    .locals 0

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->t:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    return-object p1
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z
    .locals 0

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->i:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    return-object p1
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z
    .locals 0

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->j:Z

    return p1
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    return-object p1
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z
    .locals 0

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->k:Z

    return p1
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    return-object v0
.end method

.method private e(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 205
    const-string v0, ""

    .line 206
    const-string v1, "am"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "pm"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 207
    :cond_0
    const-string v0, "am"

    const-string v1, " AM"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "pm"

    const-string v2, " PM"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 209
    :cond_1
    return-object v0
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z
    .locals 0

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->l:Z

    return p1
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->v:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->m:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->n:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->o:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    return-object v0
.end method

.method public static synthetic n(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->i:Z

    return v0
.end method

.method public static synthetic o(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->j:Z

    return v0
.end method

.method public static synthetic p(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->l:Z

    return v0
.end method

.method public static synthetic q(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->k:Z

    return v0
.end method

.method static synthetic r(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->A:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic s(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->B:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 161
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b(Ljava/lang/String;)V

    .line 162
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 163
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 164
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->v:Ljava/lang/String;

    .line 165
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 166
    const-string v2, "blueassist_update"

    iget-boolean v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->t:Z

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 167
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->v:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 168
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080141

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080143

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080144

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080140

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 172
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 173
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->startActivity(Landroid/content/Intent;)V

    .line 174
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 177
    new-instance v2, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;-><init>()V

    .line 178
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setAppointmentId(Ljava/lang/String;)V

    .line 179
    const/4 v0, 0x0

    .line 181
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->n:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->o:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 182
    const-string v3, "am"

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "pm"

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 183
    :cond_0
    const-string v3, "am"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "pm"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 186
    :cond_1
    :try_start_0
    invoke-static {v1}, Lne;->a(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 191
    :goto_0
    new-instance v1, Ljava/util/GregorianCalendar;

    invoke-direct {v1}, Ljava/util/GregorianCalendar;-><init>()V

    .line 192
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Ljava/util/GregorianCalendar;->setTimeInMillis(J)V

    .line 194
    invoke-virtual {v1}, Ljava/util/GregorianCalendar;->getTimeInMillis()J

    move-result-wide v0

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setAppointmentTime(J)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setStoreAddress(Ljava/lang/String;)V

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setStoreCity(Ljava/lang/String;)V

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setStoreId(Ljava/lang/String;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->setStoreName(Ljava/lang/String;)V

    .line 200
    invoke-static {v2}, Lfq;->a(Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;)V

    .line 202
    return-void

    .line 187
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public c(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 274
    const-string v0, "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->y:Ljava/util/regex/Pattern;

    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->y:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->z:Ljava/util/regex/Matcher;

    .line 276
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->z:Ljava/util/regex/Matcher;

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    return v0
.end method

.method public d(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 280
    const-string v0, "\\d{10}"

    invoke-virtual {p1, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 281
    const/4 v0, 0x1

    .line 283
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->x:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_1

    .line 215
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->finish()V

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 216
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->w:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 217
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 218
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 219
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->startActivity(Landroid/content/Intent;)V

    .line 220
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->finish()V

    .line 221
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/16 v6, 0x32

    const/4 v3, 0x2

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 70
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 71
    const v0, 0x7f030001

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->setContentView(I)V

    .line 72
    sget-object v0, Llu;->aQ:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 73
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->h:Lnb;

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->h:Lnb;

    invoke-virtual {v0, v4}, Lnb;->i(Z)V

    .line 75
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 77
    const v0, 0x7f0c002a

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    .line 78
    const v0, 0x7f0c002b

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    .line 79
    const v0, 0x7f0c002c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    .line 80
    const v0, 0x7f0c002d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c:Landroid/widget/EditText;

    .line 81
    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 82
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 83
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    new-instance v1, Lbv;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lbv;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    new-instance v1, Lbv;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lbv;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    new-instance v1, Lbv;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lbv;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c:Landroid/widget/EditText;

    new-instance v1, Lbv;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c:Landroid/widget/EditText;

    invoke-direct {v1, p0, v2}, Lbv;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    new-array v1, v3, [Landroid/text/InputFilter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->C:Landroid/text/InputFilter;

    aput-object v2, v1, v5

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v4

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    new-array v1, v3, [Landroid/text/InputFilter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->C:Landroid/text/InputFilter;

    aput-object v2, v1, v5

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v6}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v4

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    new-array v1, v3, [Landroid/text/InputFilter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->D:Landroid/text/InputFilter;

    aput-object v2, v1, v5

    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    const/16 v3, 0xa

    invoke-direct {v2, v3}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v2, v1, v4

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 91
    const v0, 0x7f0c002e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    .line 93
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->w:Landroid/widget/ImageView;

    .line 94
    const v0, 0x7f0c0068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->x:Landroid/widget/ImageView;

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->x:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->w:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 102
    :cond_0
    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 106
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 107
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 108
    if-eqz v1, :cond_2

    .line 109
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080054

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->o:Ljava/lang/String;

    .line 110
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080053

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->n:Ljava/lang/String;

    .line 111
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080050

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 112
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    .line 113
    const-string v0, "blueassist_update"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->t:Z

    .line 115
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f0800b9

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->v:Ljava/lang/String;

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->u:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->m:Ljava/lang/String;

    .line 117
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080141

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    .line 118
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080143

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    .line 119
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080144

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    .line 120
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080140

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    .line 122
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 125
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    if-eqz v0, :cond_4

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->s:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 128
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    if-eqz v0, :cond_5

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 131
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    if-eqz v0, :cond_6

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 134
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYButton;

    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    const v0, 0x7f0c0020

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f:Landroid/widget/RelativeLayout;

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015e

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015f

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 155
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f08021f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    const v1, 0x7f08018c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 157
    return-void
.end method
