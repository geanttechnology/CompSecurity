.class public Lbp;
.super Landroid/widget/BaseExpandableListAdapter;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

.field private b:Landroid/content/Context;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private d:I

.field private e:Lbq;

.field private f:Landroid/view/LayoutInflater;

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private h:Lbn;

.field private i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

.field private j:Z

.field private k:Z

.field private l:Landroid/widget/LinearLayout;

.field private m:Z


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;ZZ)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;ZZ)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 46
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 34
    const/4 v0, -0x1

    iput v0, p0, Lbp;->d:I

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lbp;->g:Ljava/util/ArrayList;

    .line 40
    iput-boolean v1, p0, Lbp;->j:Z

    .line 41
    iput-boolean v1, p0, Lbp;->k:Z

    .line 43
    const/4 v0, 0x1

    iput-boolean v0, p0, Lbp;->m:Z

    .line 47
    iput-object p1, p0, Lbp;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    .line 48
    iput-object p2, p0, Lbp;->b:Landroid/content/Context;

    .line 49
    iput-object p3, p0, Lbp;->c:Ljava/util/ArrayList;

    .line 50
    iput-object p4, p0, Lbp;->g:Ljava/util/ArrayList;

    .line 51
    iput-boolean p5, p0, Lbp;->j:Z

    .line 52
    iput-boolean p6, p0, Lbp;->k:Z

    .line 53
    const-string v0, "layout_inflater"

    invoke-virtual {p2, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lbp;->f:Landroid/view/LayoutInflater;

    .line 54
    return-void
.end method

.method static synthetic a(Lbp;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lbp;->l:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic b(Lbp;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lbp;->g:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 236
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.DIAL"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "tel:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lbp;->b:Landroid/content/Context;

    const v4, 0x7f0800cc

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 237
    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 238
    iget-object v0, p0, Lbp;->b:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 239
    return-void
.end method

.method public b()V
    .locals 6

    .prologue
    .line 242
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 243
    const-string v1, "android.intent.extra.EMAIL"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lbp;->b:Landroid/content/Context;

    const v5, 0x7f0800cb

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 244
    const-string v1, "android.intent.extra.SUBJECT"

    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    const v3, 0x7f080183

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 245
    const-string v1, "android.intent.extra.TEXT"

    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    const v3, 0x7f080181

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 246
    const-string v1, "message/rfc822"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 247
    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    const-string v2, "Choose an Email client :"

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 248
    iget-object v0, p0, Lbp;->b:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 249
    return-void
.end method

.method public c()Z
    .locals 2

    .prologue
    .line 251
    iget-object v0, p0, Lbp;->b:Landroid/content/Context;

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getLine1Number()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getChild(II)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 80
    const/4 v0, 0x0

    return-object v0
.end method

.method public getChildId(II)J
    .locals 2

    .prologue
    .line 90
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7

    .prologue
    const v5, 0x7f0c0114

    const/16 v4, 0x8

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 120
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802c8

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 121
    iget-boolean v0, p0, Lbp;->m:Z

    if-nez v0, :cond_0

    .line 124
    sget-object v0, Llu;->aV:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 126
    :cond_0
    iput-boolean v3, p0, Lbp;->m:Z

    .line 127
    iget-object v0, p0, Lbp;->f:Landroid/view/LayoutInflater;

    const v1, 0x7f03004c

    invoke-virtual {v0, v1, v6, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 128
    const v0, 0x7f0c011a

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 129
    iget-boolean v1, p0, Lbp;->j:Z

    if-nez v1, :cond_2

    .line 130
    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 135
    :goto_0
    const v0, 0x7f0c0116

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 136
    iget-boolean v1, p0, Lbp;->k:Z

    if-nez v1, :cond_3

    .line 137
    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 141
    :goto_1
    invoke-virtual {p4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lbp;->l:Landroid/widget/LinearLayout;

    .line 142
    iget-object v0, p0, Lbp;->l:Landroid/widget/LinearLayout;

    new-instance v1, Lbp$1;

    invoke-direct {v1, p0}, Lbp$1;-><init>(Lbp;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 205
    :cond_1
    :goto_2
    return-object p4

    .line 132
    :cond_2
    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    check-cast v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 139
    :cond_3
    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    check-cast v1, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    const-string v2, "PurchasingProduct"

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Ljava/lang/String;)Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_1

    .line 156
    :cond_4
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080197

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 157
    sget-object v0, Llu;->aZ:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lbp;->f:Landroid/view/LayoutInflater;

    const v1, 0x7f030048

    invoke-virtual {v0, v1, v6, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 159
    const v0, 0x7f0c0115

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    iput-object v0, p0, Lbp;->i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    .line 160
    new-instance v0, Lbn;

    iget-object v1, p0, Lbp;->i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    iget-object v3, p0, Lbp;->g:Ljava/util/ArrayList;

    iget-boolean v4, p0, Lbp;->j:Z

    iget-boolean v5, p0, Lbp;->k:Z

    invoke-direct/range {v0 .. v5}, Lbn;-><init>(Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;Landroid/content/Context;Ljava/util/ArrayList;ZZ)V

    iput-object v0, p0, Lbp;->h:Lbn;

    .line 161
    new-instance v0, Lfd;

    iget-object v1, p0, Lbp;->h:Lbn;

    invoke-direct {v0, v1}, Lfd;-><init>(Landroid/widget/ExpandableListAdapter;)V

    .line 162
    iget-object v1, p0, Lbp;->i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 163
    iget-object v0, p0, Lbp;->i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;->setGroupIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 164
    iget-object v0, p0, Lbp;->i:Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;

    new-instance v1, Lbp$2;

    invoke-direct {v1, p0}, Lbp$2;-><init>(Lbp;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/askexpert/CustomGroupExpandableListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    goto :goto_2

    .line 173
    :cond_5
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080329

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 174
    sget-object v0, Llu;->aI:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 175
    iget-object v0, p0, Lbp;->f:Landroid/view/LayoutInflater;

    const v1, 0x7f03004d

    invoke-virtual {v0, v1, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 176
    const v0, 0x7f0c0117

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 177
    new-instance v1, Lbp$3;

    invoke-direct {v1, p0}, Lbp$3;-><init>(Lbp;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 189
    invoke-virtual {p4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 190
    new-instance v1, Lbp$4;

    invoke-direct {v1, p0, v0}, Lbp$4;-><init>(Lbp;Landroid/widget/LinearLayout;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_2
.end method

.method public getChildrenCount(I)I
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 63
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 64
    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802c8

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080329

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    move v0, v1

    .line 70
    :goto_0
    return v0

    .line 67
    :cond_1
    iget-object v2, p0, Lbp;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080197

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    .line 68
    goto :goto_0

    .line 70
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lbp;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2

    .prologue
    .line 85
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3

    .prologue
    .line 100
    if-nez p3, :cond_0

    .line 101
    new-instance v0, Lbq;

    invoke-direct {v0}, Lbq;-><init>()V

    iput-object v0, p0, Lbp;->e:Lbq;

    .line 102
    iget-object v0, p0, Lbp;->f:Landroid/view/LayoutInflater;

    const v1, 0x7f03004b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p4, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p3

    .line 103
    iget-object v1, p0, Lbp;->e:Lbq;

    const v0, 0x7f0c0118

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lbq;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 104
    iget-object v1, p0, Lbp;->e:Lbq;

    const v0, 0x7f0c0119

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lbq;->b:Landroid/widget/ImageView;

    .line 105
    iget-object v0, p0, Lbp;->e:Lbq;

    invoke-virtual {p3, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 109
    :goto_0
    iget-object v0, p0, Lbp;->e:Lbq;

    iget-object v1, v0, Lbq;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, p1}, Lbp;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 110
    if-eqz p2, :cond_1

    .line 111
    iget-object v0, p0, Lbp;->e:Lbq;

    iget-object v0, v0, Lbq;->b:Landroid/widget/ImageView;

    const v1, 0x7f020012

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 115
    :goto_1
    return-object p3

    .line 107
    :cond_0
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lbq;

    iput-object v0, p0, Lbp;->e:Lbq;

    goto :goto_0

    .line 113
    :cond_1
    iget-object v0, p0, Lbp;->e:Lbq;

    iget-object v0, v0, Lbq;->b:Landroid/widget/ImageView;

    const v1, 0x7f020011

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x1

    return v0
.end method

.method public onGroupCollapsed(I)V
    .locals 1

    .prologue
    .line 230
    iget v0, p0, Lbp;->d:I

    if-ne v0, p1, :cond_0

    .line 231
    const/4 v0, -0x1

    iput v0, p0, Lbp;->d:I

    .line 233
    :cond_0
    return-void
.end method

.method public onGroupExpanded(I)V
    .locals 2

    .prologue
    .line 220
    iget v0, p0, Lbp;->d:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 221
    iput p1, p0, Lbp;->d:I

    .line 226
    :goto_0
    return-void

    .line 223
    :cond_0
    iget-object v0, p0, Lbp;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget v1, p0, Lbp;->d:I

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->collapseGroup(I)Z

    .line 224
    iput p1, p0, Lbp;->d:I

    goto :goto_0
.end method
