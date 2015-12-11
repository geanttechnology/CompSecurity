.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field private a:Landroid/app/DatePickerDialog$OnDateSetListener;

.field private b:Ljava/util/Calendar;

.field private c:Ljava/lang/String;

.field private d:Landroid/widget/ListView;

.field private e:Ljava/lang/String;

.field private f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private g:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private h:Lbt;

.field private i:Landroid/widget/ProgressBar;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private k:Z

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Landroid/widget/ImageView;

.field private t:Landroid/widget/ImageView;

.field private u:Landroid/app/DatePickerDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 272
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->e:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b:Ljava/util/Calendar;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 166
    new-instance v0, Lhw;

    const-string v4, ""

    iget-object v5, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->i:Landroid/widget/ProgressBar;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lhw;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V

    .line 167
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 168
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    return-object p1
.end method

.method private b()V
    .locals 3

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 120
    const v0, 0x7f0c0020

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 121
    const v1, 0x7f0c015e

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 122
    const v2, 0x7f0c015f

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 123
    const v2, 0x7f08021f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 124
    const v1, 0x7f0802fb

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    const v0, 0x7f0c0062

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 127
    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 129
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 130
    const-string v1, "EEE, MMM dd"

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    invoke-static {v2}, Lne;->b(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    invoke-static {v1, v2}, Lne;->a(Ljava/lang/String;Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 135
    :goto_0
    const v1, 0x7f0c0065

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->i:Landroid/widget/ProgressBar;

    .line 137
    const v1, 0x7f0c0066

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 139
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 141
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b:Ljava/util/Calendar;

    .line 143
    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity$1;

    invoke-direct {v1, p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Lcom/bestbuy/android/bbyobjects/BBYTextView;)V

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 163
    return-void

    .line 132
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Today - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "EEE, MMM dd"

    invoke-static {v2}, Lne;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    return-object v0
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->o:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->u:Landroid/app/DatePickerDialog;

    if-nez v0, :cond_0

    .line 172
    new-instance v0, Landroid/app/DatePickerDialog;

    const v2, 0x7f0e0012

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a:Landroid/app/DatePickerDialog$OnDateSetListener;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b:Ljava/util/Calendar;

    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/util/Calendar;->get(I)I

    move-result v4

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b:Ljava/util/Calendar;

    const/4 v5, 0x2

    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v1, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;ILandroid/app/DatePickerDialog$OnDateSetListener;III)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->u:Landroid/app/DatePickerDialog;

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->u:Landroid/app/DatePickerDialog;

    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    sub-long/2addr v2, v4

    invoke-virtual {v0, v2, v3}, Landroid/widget/DatePicker;->setMinDate(J)V

    .line 176
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 177
    const/4 v1, 0x6

    const/16 v2, 0x5a

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->add(II)V

    .line 178
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->u:Landroid/app/DatePickerDialog;

    invoke-virtual {v1}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 180
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->u:Landroid/app/DatePickerDialog;

    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    .line 181
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 185
    if-eqz p1, :cond_0

    .line 186
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;

    .line 187
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;->getSlots()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 189
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 190
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->f:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 191
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->f:Ljava/util/List;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;->getSlots()Ljava/util/ArrayList;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->h:Lbt;

    if-eqz v0, :cond_1

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->h:Lbt;

    invoke-virtual {v0}, Lbt;->notifyDataSetChanged()V

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    new-instance v0, Lbt;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->f:Ljava/util/List;

    invoke-direct {v0, p0, p0, v1}, Lbt;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->h:Lbt;

    .line 196
    const v0, 0x102000a

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d:Landroid/widget/ListView;

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->h:Lbt;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d:Landroid/widget/ListView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d:Landroid/widget/ListView;

    const v1, 0x7f02002d

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setBackgroundResource(I)V

    goto :goto_0

    .line 203
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/high16 v3, 0x4000000

    .line 211
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 218
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->t:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_2

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 220
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistAptConfirmationActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 221
    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 222
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 223
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 224
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080054

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->o:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080053

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 226
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080050

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->g:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 227
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080141

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->l:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080143

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->m:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 229
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080144

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->n:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080140

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->p:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 233
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 234
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->finish()V

    .line 245
    :cond_0
    :goto_1
    return-void

    .line 213
    :pswitch_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a()V

    goto/16 :goto_0

    .line 236
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->finish()V

    goto :goto_1

    .line 238
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->s:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 239
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 240
    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 241
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 242
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->finish()V

    .line 243
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->overridePendingTransition(II)V

    goto :goto_1

    .line 211
    :pswitch_data_0
    .packed-switch 0x7f0c0062
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 75
    const v0, 0x7f030012

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->setContentView(I)V

    .line 77
    sget-object v0, Llu;->aP:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 82
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 83
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 84
    if-eqz v1, :cond_0

    .line 85
    const-string v0, "blueassist_update"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->k:Z

    .line 86
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080141

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->l:Ljava/lang/String;

    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080143

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->m:Ljava/lang/String;

    .line 88
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080144

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->n:Ljava/lang/String;

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080140

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->p:Ljava/lang/String;

    .line 90
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f0800b9

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    .line 91
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080050

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->g:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->g:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    .line 93
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080053

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    .line 94
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080054

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->o:Ljava/lang/String;

    .line 96
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->b()V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 98
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->f:Ljava/util/List;

    .line 99
    invoke-static {}, Lne;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->e:Ljava/lang/String;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 103
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->k:Z

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    :cond_1
    :goto_0
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->s:Landroid/widget/ImageView;

    .line 112
    const v0, 0x7f0c0068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->t:Landroid/widget/ImageView;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->t:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->s:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    return-void

    .line 107
    :cond_2
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->k:Z

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->c:Ljava/lang/String;

    invoke-static {}, Lne;->a()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const v3, 0x7f080053

    .line 249
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 250
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 251
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080054

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->f:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 254
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->r:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080050

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->g:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 260
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->k:Z

    if-eqz v0, :cond_0

    .line 261
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080141

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->l:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080143

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->m:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080144

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->n:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080140

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->p:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f0800b9

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->q:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 268
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 269
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 270
    return-void

    .line 256
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->e:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
