.class public Lcom/bestbuy/android/activities/registry/WeddingDateFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private c:Landroid/app/DatePickerDialog$OnDateSetListener;

.field private g:Ljava/util/Calendar;

.field private h:Z

.field private i:Z

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 48
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->h:Z

    .line 43
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->i:Z

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->h:Z

    .line 43
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->i:Z

    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->l:Ljava/lang/String;

    .line 53
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->g:Ljava/util/Calendar;

    return-object v0
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z
    .locals 0

    .prologue
    .line 36
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->h:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    return-object v0
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z
    .locals 0

    .prologue
    .line 36
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->i:Z

    return p1
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->h:Z

    return v0
.end method


# virtual methods
.method public g()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 113
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->i:Z

    if-eqz v0, :cond_1

    .line 114
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 116
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->eventDate:Ljava/lang/String;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->l:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->l:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 119
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->l:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;Ljava/lang/String;)V

    move-object v2, v0

    .line 123
    :goto_0
    const-string v0, "data"

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 124
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 125
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->setArguments(Landroid/os/Bundle;)V

    .line 126
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 127
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WeddingAddressFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 129
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_1

    .line 130
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 133
    :cond_1
    return-void

    .line 121
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    move-object v2, v0

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 58
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->d:Landroid/app/Activity;

    .line 59
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 60
    if-eqz v0, :cond_0

    .line 61
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    :cond_0
    move-object v0, p1

    .line 63
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 64
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 65
    sget-object v0, Llu;->av:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 66
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    if-ne p1, v0, :cond_0

    .line 138
    new-instance v0, Landroid/app/DatePickerDialog;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->c:Landroid/app/DatePickerDialog$OnDateSetListener;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->g:Ljava/util/Calendar;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->get(I)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->g:Ljava/util/Calendar;

    invoke-virtual {v4, v7}, Ljava/util/Calendar;->get(I)I

    move-result v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->g:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 141
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    sub-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMinDate(J)V

    .line 142
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 143
    const/16 v2, 0x12

    invoke-virtual {v1, v7, v2}, Ljava/util/Calendar;->add(II)V

    .line 144
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v2

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 145
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->j:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 150
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->k:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 153
    :cond_2
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 71
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 82
    const v0, 0x7f030113

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 83
    const v0, 0x7f0c03f3

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->j:Landroid/widget/LinearLayout;

    .line 84
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->k:Landroid/widget/LinearLayout;

    .line 85
    const v0, 0x7f0c03f4

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    new-instance v2, Ldc;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Ldc;-><init>(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 87
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->g:Ljava/util/Calendar;

    .line 88
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->c:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    return-object v1
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 75
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 78
    return-void
.end method
