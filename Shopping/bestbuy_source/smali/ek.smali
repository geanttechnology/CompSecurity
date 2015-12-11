.class public Lek;
.super Landroid/widget/BaseExpandableListAdapter;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/content/Context;

.field private c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private d:Landroid/view/LayoutInflater;

.field private e:Landroid/widget/ExpandableListView;

.field private f:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

.field private g:I


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;Landroid/widget/ExpandableListView;Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;",
            "Landroid/widget/ExpandableListView;",
            "Landroid/content/Context;",
            "Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 52
    const/4 v0, -0x1

    iput v0, p0, Lek;->g:I

    .line 56
    iput-object p1, p0, Lek;->f:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    .line 57
    iput-object p2, p0, Lek;->e:Landroid/widget/ExpandableListView;

    .line 58
    iput-object p3, p0, Lek;->b:Landroid/content/Context;

    .line 59
    iput-object p4, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 60
    iput-object p5, p0, Lek;->a:Ljava/util/ArrayList;

    .line 62
    iget-object v0, p0, Lek;->b:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    .line 70
    return-void
.end method

.method static synthetic a(Lek;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lek;->b:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic a(Lek;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lek;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 708
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1, v4, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 709
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 710
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 711
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 712
    iget-object v0, p0, Lek;->f:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 713
    return-void
.end method


# virtual methods
.method public getChild(II)Ljava/lang/Object;
    .locals 10

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 149
    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 150
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802b8

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 151
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getLongDesc()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getLongDesc()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 152
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getLongDesc()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 213
    :goto_0
    return-object v0

    .line 154
    :cond_0
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getShortDesc()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 155
    :cond_1
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802bf

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 156
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getSynopsis()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 157
    :cond_2
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 158
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 159
    :cond_3
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802ba

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 160
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getIncludedItems()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 161
    :cond_4
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802be

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 162
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecifications()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 163
    :cond_5
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802bd

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 164
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-ge p2, v0, :cond_6

    .line 165
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, p2, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 166
    :cond_6
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v0, v2

    add-int/lit8 v0, v0, 0x2

    if-ge p2, v0, :cond_7

    .line 167
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    sub-int v1, p2, v1

    add-int/lit8 v1, v1, -0x2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 168
    :cond_7
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v0, v2

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/2addr v0, v2

    add-int/lit8 v0, v0, 0x3

    if-ge p2, v0, :cond_1e

    .line 170
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    sub-int v1, p2, v1

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    sub-int/2addr v1, v2

    add-int/lit8 v1, v1, -0x3

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 172
    :cond_8
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08023b

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 173
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 174
    :cond_9
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08018f

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 175
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEpisodesList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 176
    :cond_a
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08032e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 177
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecialFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 178
    :cond_b
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800ee

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_19

    .line 179
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v2

    .line 180
    if-eqz v2, :cond_d

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCastMembers()Ljava/util/List;

    move-result-object v0

    move-object v3, v0

    .line 181
    :goto_1
    if-eqz v2, :cond_e

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v0

    move-object v2, v0

    .line 182
    :goto_2
    if-eqz v3, :cond_f

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    move v8, v0

    .line 183
    :goto_3
    if-eqz v2, :cond_10

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_10

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v7, v0

    .line 184
    :goto_4
    if-eqz v2, :cond_11

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_11

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v6, v0

    .line 185
    :goto_5
    if-eqz v2, :cond_12

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_12

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v5, v0

    .line 187
    :goto_6
    if-lez v8, :cond_c

    const/4 v4, 0x1

    .line 188
    :cond_c
    if-lez v7, :cond_13

    add-int/lit8 v3, v4, 0x1

    .line 189
    :goto_7
    if-lez v6, :cond_14

    add-int/lit8 v2, v3, 0x1

    .line 190
    :goto_8
    if-lez v5, :cond_15

    add-int/lit8 v0, v2, 0x1

    .line 192
    :goto_9
    if-lez v8, :cond_16

    add-int v9, v8, v4

    if-ge p2, v9, :cond_16

    .line 193
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCastMembers()Ljava/util/List;

    move-result-object v0

    sub-int v1, p2, v4

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    :cond_d
    move-object v3, v1

    .line 180
    goto :goto_1

    :cond_e
    move-object v2, v1

    .line 181
    goto :goto_2

    :cond_f
    move v8, v4

    .line 182
    goto :goto_3

    :cond_10
    move v7, v4

    .line 183
    goto :goto_4

    :cond_11
    move v6, v4

    .line 184
    goto :goto_5

    :cond_12
    move v5, v4

    .line 185
    goto :goto_6

    :cond_13
    move v3, v4

    .line 188
    goto :goto_7

    :cond_14
    move v2, v3

    .line 189
    goto :goto_8

    :cond_15
    move v0, v2

    .line 190
    goto :goto_9

    .line 194
    :cond_16
    if-lez v7, :cond_17

    add-int v4, v8, v7

    add-int/2addr v4, v3

    if-ge p2, v4, :cond_17

    .line 195
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    sub-int v1, p2, v8

    sub-int/2addr v1, v3

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 196
    :cond_17
    if-lez v6, :cond_18

    add-int v3, v8, v7

    add-int/2addr v3, v6

    add-int/2addr v3, v2

    if-ge p2, v3, :cond_18

    .line 197
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    sub-int v1, p2, v8

    sub-int/2addr v1, v7

    sub-int/2addr v1, v2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 198
    :cond_18
    if-lez v5, :cond_1e

    add-int v2, v8, v7

    add-int/2addr v2, v6

    add-int/2addr v2, v5

    add-int/2addr v2, v0

    if-ge p2, v2, :cond_1e

    .line 199
    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v1

    sub-int v2, p2, v8

    sub-int/2addr v2, v7

    sub-int/2addr v2, v6

    sub-int v0, v2, v0

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 201
    :cond_19
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080241

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1a

    .line 202
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMusicResponse()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;->getMusicDetails()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 203
    :cond_1a
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08032a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1b

    .line 204
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1e

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;->getTracks()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1e

    .line 205
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;->getTracks()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 206
    :cond_1b
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080327

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1c

    .line 207
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSoftwareDetails()Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 208
    :cond_1c
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801b3

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1d

    .line 209
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getGameDetails()Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    .line 210
    :cond_1d
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801b0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 211
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBonusContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto/16 :goto_0

    :cond_1e
    move-object v0, v1

    .line 213
    goto/16 :goto_0
.end method

.method public getChildId(II)J
    .locals 2

    .prologue
    .line 223
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10

    .prologue
    .line 292
    const-string v1, ""

    .line 293
    invoke-virtual {p0, p1}, Lek;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 294
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802b8

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 295
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009a

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 296
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 297
    const-string v1, "[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|\'?/<,>/\"\\+]"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 298
    const v0, 0x7f0c024d

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    .line 299
    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    .line 300
    const/16 v3, 0xd

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setDefaultFontSize(I)V

    .line 301
    const-string v3, "utf-8"

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V

    .line 303
    const-string v2, "<a.*?>|</a>"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 305
    const-string v2, "<img.*?>"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 307
    const-string v2, "<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/Roboto-Regular.ttf\")}body {color: #49494A; background-color: #ffffff; font-family: MyFont;font-size: 13;text-align: justify;}</style></head><body>"

    .line 308
    const-string v3, "</body></html>"

    .line 309
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "text/html"

    const-string v3, "UTF-8"

    invoke-virtual {v0, v1, v2, v3}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p4

    .line 704
    :goto_0
    return-object v0

    .line 314
    :cond_0
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802bf

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 315
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 316
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 317
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 318
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 319
    const-string v2, "[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|\'?/<,>/\"\\+]"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 320
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v2

    .line 321
    const/4 v3, -0x1

    if-eq v2, v3, :cond_1

    .line 322
    const/4 v3, 0x0

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v0, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 323
    :cond_1
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, p4

    .line 324
    goto :goto_0

    :cond_2
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 325
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f030098

    const/4 v3, 0x0

    invoke-virtual {v0, v2, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 326
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Feature;

    .line 327
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2}, Ljava/lang/String;-><init>()V

    .line 328
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_3b

    .line 329
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    move-object v3, v1

    .line 331
    :goto_1
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3a

    .line 332
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    move-object v4, v1

    .line 334
    :goto_2
    const v1, 0x7f0c0249

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 335
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 336
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 337
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_5

    .line 338
    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 343
    :cond_3
    :goto_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getDescription()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 344
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_6

    .line 345
    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    :cond_4
    :goto_4
    move-object v0, p4

    .line 350
    goto/16 :goto_0

    .line 340
    :cond_5
    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_3

    .line 347
    :cond_6
    const/16 v0, 0x8

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_4

    .line 350
    :cond_7
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802ba

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 351
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030099

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 352
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/IncludedItem;

    .line 353
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 354
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/IncludedItem;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, p4

    .line 355
    goto/16 :goto_0

    :cond_8
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802be

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 356
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f0300a3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 357
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    .line 358
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 359
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 360
    const v3, 0x7f0c024f

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 361
    const v4, 0x7f0c0252

    invoke-virtual {p4, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 362
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 363
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 364
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDefinition()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_9

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDefinition()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_9

    .line 365
    new-instance v1, Lek$1;

    invoke-direct {v1, p0, v4, v0}, Lek$1;-><init>(Lek;Lcom/bestbuy/android/bbyobjects/BBYTextView;Lcom/bestbuy/android/api/lib/models/pdp/Specification;)V

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 376
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    :cond_9
    move-object v0, p4

    .line 378
    goto/16 :goto_0

    :cond_a
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802bd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 379
    if-nez p2, :cond_e

    .line 380
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 381
    const v0, 0x7f0c0248

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 382
    const v1, 0x7f0c024e

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 383
    const v2, 0x7f0b0008

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 384
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802c2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 385
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 387
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 389
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getPlanType()Ljava/lang/String;

    move-result-object v0

    .line 390
    if-eqz v0, :cond_c

    const-string v2, "GSP-R"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 391
    const-string v0, "Replacement Plan"

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    :cond_b
    :goto_5
    move-object v0, p4

    .line 398
    goto/16 :goto_0

    .line 392
    :cond_c
    if-eqz v0, :cond_d

    const-string v2, "GSP"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 393
    const-string v0, "Standard Protection Plan"

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_5

    .line 394
    :cond_d
    if-eqz v0, :cond_b

    const-string v2, "ADH"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 395
    iget-object v0, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f080095

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_5

    .line 398
    :cond_e
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-ne v0, p2, :cond_f

    .line 399
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 400
    const v0, 0x7f0c0248

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 401
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802a2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 402
    const v1, 0x7f0b0008

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    move-object v0, p4

    .line 403
    goto/16 :goto_0

    :cond_f
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x2

    if-ne v0, p2, :cond_10

    .line 405
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 406
    const v0, 0x7f0c0248

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 407
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800bf

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 408
    const v1, 0x7f0b0008

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    move-object v0, p4

    .line 409
    goto/16 :goto_0

    .line 411
    :cond_10
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-ge p2, v0, :cond_14

    .line 413
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 414
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;

    .line 416
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 417
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 419
    const v1, 0x7f0c0250

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 420
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 421
    const v3, 0x7f0c024f

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 422
    const v4, 0x7f0c0252

    invoke-virtual {p4, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 423
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getTitle()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_13

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_13

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v5

    if-eqz v5, :cond_13

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_13

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_13

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getColumns()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v5

    const-string v6, "true"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_13

    .line 425
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 431
    :goto_6
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_11

    .line 432
    new-instance v1, Lek$2;

    invoke-direct {v1, p0, v4, v0}, Lek$2;-><init>(Lek;Lcom/bestbuy/android/bbyobjects/BBYTextView;Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ConditionalFeature;)V

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 444
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 513
    :cond_11
    :goto_7
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x3

    .line 515
    add-int/lit8 v1, p2, 0x1

    if-ne v1, v0, :cond_12

    .line 516
    const v0, 0x7f0c0251

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 517
    const v1, 0x7f08016e

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(I)V

    .line 518
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    :cond_12
    move-object v0, p4

    .line 520
    goto/16 :goto_0

    .line 429
    :cond_13
    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_6

    .line 447
    :cond_14
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x2

    if-ge p2, v0, :cond_16

    .line 448
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 449
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;

    .line 450
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 451
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 452
    const v1, 0x7f0c0250

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 453
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 454
    const v3, 0x7f0c024f

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 455
    const v4, 0x7f0c0252

    invoke-virtual {p4, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 456
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getTitle()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_15

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_15

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getColumns()Ljava/util/List;

    move-result-object v5

    if-eqz v5, :cond_15

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getColumns()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_15

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getColumns()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_15

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getColumns()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v5

    const-string v6, "true"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 458
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 464
    :goto_8
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_11

    .line 465
    new-instance v1, Lek$3;

    invoke-direct {v1, p0, v4, v0}, Lek$3;-><init>(Lek;Lcom/bestbuy/android/bbyobjects/BBYTextView;Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Common;)V

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 477
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_7

    .line 462
    :cond_15
    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_8

    .line 479
    :cond_16
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x3

    if-ge p2, v0, :cond_11

    .line 481
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 482
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;

    .line 483
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 484
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getTerm()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 485
    const v1, 0x7f0c0250

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 486
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 487
    const v3, 0x7f0c024f

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 488
    const v3, 0x7f0c0252

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 489
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getTerm()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_17

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getTerm()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_17

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getColumns()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_17

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getColumns()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_17

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getColumns()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_17

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getColumns()Ljava/util/List;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getServiceInFeature()Ljava/lang/String;

    move-result-object v3

    const-string v4, "true"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_17

    .line 491
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_7

    .line 493
    :cond_17
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "$"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Term;->getColumns()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->getPrice()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 494
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_7

    .line 521
    :cond_18
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08023b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 522
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009c

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 523
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;

    .line 524
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 525
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 526
    if-eqz v0, :cond_19

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getLink()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    move-result-object v3

    if-eqz v3, :cond_19

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getLink()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_19

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getLink()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_19

    .line 528
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 529
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 530
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v3, 0x7f0b0000

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 531
    new-instance v1, Lek$4;

    invoke-direct {v1, p0, v0}, Lek$4;-><init>(Lek;Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;)V

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :goto_9
    move-object v0, p4

    .line 542
    goto/16 :goto_0

    .line 539
    :cond_19
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 540
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_9

    .line 542
    :cond_1a
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08018f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1b

    .line 543
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f0300a6

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 544
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/episodes/Episode;

    .line 545
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 546
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/Episode;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, p4

    .line 547
    goto/16 :goto_0

    :cond_1b
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08032e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1c

    .line 548
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f0300a2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 549
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    .line 550
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 551
    const v0, 0x7f0c024c

    invoke-virtual {p4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 552
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, p4

    .line 554
    goto/16 :goto_0

    :cond_1c
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800ee

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_31

    .line 555
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v1

    .line 556
    if-eqz v1, :cond_1d

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCastMembers()Ljava/util/List;

    move-result-object v0

    move-object v2, v0

    .line 557
    :goto_a
    if-eqz v1, :cond_1e

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v0

    move-object v1, v0

    .line 558
    :goto_b
    if-eqz v2, :cond_1f

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    move v7, v0

    .line 559
    :goto_c
    if-eqz v1, :cond_20

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_20

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v6, v0

    .line 560
    :goto_d
    if-eqz v1, :cond_21

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_21

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v5, v0

    .line 561
    :goto_e
    if-eqz v1, :cond_22

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_22

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    move v3, v0

    .line 563
    :goto_f
    if-lez v7, :cond_23

    const/4 v2, 0x1

    .line 564
    :goto_10
    if-lez v6, :cond_24

    add-int/lit8 v1, v2, 0x1

    .line 565
    :goto_11
    if-lez v5, :cond_25

    add-int/lit8 v0, v1, 0x1

    .line 568
    :goto_12
    if-lez v7, :cond_26

    if-nez p2, :cond_26

    .line 569
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030097

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 570
    const v0, 0x7f0c0248

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 571
    const-string v2, "Cast Member"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v1

    .line 572
    goto/16 :goto_0

    .line 556
    :cond_1d
    const/4 v0, 0x0

    move-object v2, v0

    goto :goto_a

    .line 557
    :cond_1e
    const/4 v0, 0x0

    move-object v1, v0

    goto :goto_b

    .line 558
    :cond_1f
    const/4 v0, 0x0

    move v7, v0

    goto :goto_c

    .line 559
    :cond_20
    const/4 v0, 0x0

    move v6, v0

    goto :goto_d

    .line 560
    :cond_21
    const/4 v0, 0x0

    move v5, v0

    goto :goto_e

    .line 561
    :cond_22
    const/4 v0, 0x0

    move v3, v0

    goto :goto_f

    .line 563
    :cond_23
    const/4 v2, 0x0

    goto :goto_10

    :cond_24
    move v1, v2

    .line 564
    goto :goto_11

    :cond_25
    move v0, v1

    .line 565
    goto :goto_12

    .line 573
    :cond_26
    if-lez v6, :cond_27

    add-int v4, v7, v2

    if-ne v4, p2, :cond_27

    .line 574
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030097

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 575
    const v0, 0x7f0c0248

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 576
    const-string v2, "Writers"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v1

    .line 577
    goto/16 :goto_0

    :cond_27
    if-lez v5, :cond_28

    add-int v4, v7, v6

    add-int/2addr v4, v1

    if-ne v4, p2, :cond_28

    .line 578
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030097

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 579
    const v0, 0x7f0c0248

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 580
    const-string v2, "Director"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v1

    .line 581
    goto/16 :goto_0

    :cond_28
    if-lez v3, :cond_29

    add-int v4, v7, v6

    add-int/2addr v4, v5

    add-int/2addr v4, v0

    if-ne v4, p2, :cond_29

    .line 582
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030097

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 583
    const v0, 0x7f0c0248

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 584
    const-string v2, "Other Crew"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v1

    .line 585
    goto/16 :goto_0

    .line 587
    :cond_29
    iget-object v4, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v8, 0x7f030096

    const/4 v9, 0x0

    invoke-virtual {v4, v8, p5, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 588
    if-lez v7, :cond_2d

    add-int/2addr v2, v7

    if-ge p2, v2, :cond_2d

    .line 589
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;

    .line 590
    const v1, 0x7f0c0245

    invoke-virtual {v4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 591
    const v2, 0x7f0c0246

    invoke-virtual {v4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 592
    const v3, 0x7f0c0247

    invoke-virtual {v4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 594
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getHeadshotImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v5

    if-eqz v5, :cond_2a

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getHeadshotImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/home/ImageType;->getUrl()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_2a

    .line 595
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getHeadshotImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/home/ImageType;->getUrl()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v5, v3, v6}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 596
    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 598
    :cond_2a
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 600
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_2b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2b

    .line 601
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 602
    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 604
    :cond_2b
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_2c

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2c

    .line 605
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastMember;->getCharacterNames()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CharacterName;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "no char name"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2c

    .line 606
    const/16 v0, 0x8

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    :cond_2c
    move-object v0, v4

    .line 610
    goto/16 :goto_0

    :cond_2d
    if-lez v6, :cond_2e

    add-int v2, v7, v6

    add-int/2addr v1, v2

    if-ge p2, v1, :cond_2e

    .line 611
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;

    .line 612
    const v1, 0x7f0c0245

    invoke-virtual {v4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 613
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v4

    .line 614
    goto/16 :goto_0

    :cond_2e
    if-lez v5, :cond_2f

    add-int v1, v7, v6

    add-int/2addr v1, v5

    add-int/2addr v1, v0

    if-ge p2, v1, :cond_2f

    .line 615
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;

    .line 616
    const v1, 0x7f0c0245

    invoke-virtual {v4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 617
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v4

    .line 618
    goto/16 :goto_0

    :cond_2f
    if-lez v3, :cond_30

    add-int v1, v7, v6

    add-int/2addr v1, v5

    add-int/2addr v1, v3

    add-int/2addr v0, v1

    if-gt p2, v0, :cond_30

    .line 619
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;

    .line 620
    const v1, 0x7f0c0245

    invoke-virtual {v4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 621
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 622
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getRole()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_30

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getRole()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_30

    .line 623
    const v1, 0x7f0c0246

    invoke-virtual {v4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 624
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/Person;->getRole()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 625
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    :cond_30
    move-object v0, v4

    goto/16 :goto_0

    .line 630
    :cond_31
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080241

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_32

    .line 631
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009d

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 632
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;

    .line 633
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 634
    const v2, 0x7f0c024a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 635
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 636
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicSpecifications;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 637
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    move-object v0, p4

    .line 638
    goto/16 :goto_0

    :cond_32
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08032a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_34

    .line 639
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f03009d

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 640
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Track;

    .line 641
    const v1, 0x7f0c00c8

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 642
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getPlayURL()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_33

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getPlayURL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_33

    .line 643
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 645
    :cond_33
    const v1, 0x7f0c024c

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 646
    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    const/4 v3, -0x2

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 647
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 648
    new-instance v1, Lek$5;

    invoke-direct {v1, p0, v0}, Lek$5;-><init>(Lek;Lcom/bestbuy/android/api/lib/models/pdp/Track;)V

    invoke-virtual {p4, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v0, p4

    .line 660
    goto/16 :goto_0

    :cond_34
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080327

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_36

    .line 661
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    .line 662
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_35

    .line 663
    iget-object v1, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f0300a0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 664
    const v1, 0x7f0c0253

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 665
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v2

    .line 666
    goto/16 :goto_0

    .line 668
    :cond_35
    iget-object v1, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f0300a1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 669
    const v1, 0x7f0c0254

    invoke-virtual {v3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 670
    const v2, 0x7f0c0255

    invoke-virtual {v3, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 671
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 672
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    :goto_13
    move-object v0, v3

    goto/16 :goto_0

    .line 674
    :cond_36
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801b3

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_38

    .line 675
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    .line 676
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_37

    .line 677
    iget-object v1, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f0300a0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 678
    const v1, 0x7f0c0253

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 679
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v2

    .line 680
    goto/16 :goto_0

    .line 681
    :cond_37
    iget-object v1, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f0300a1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p5, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 682
    const v1, 0x7f0c0254

    invoke-virtual {v3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 683
    const v2, 0x7f0c0255

    invoke-virtual {v3, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 684
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 685
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_13

    .line 687
    :cond_38
    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801b0

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_39

    .line 688
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f0300a8

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 689
    invoke-virtual {p0, p1, p2}, Lek;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;

    .line 690
    const v1, 0x7f0c0280

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 691
    const v2, 0x7f0c0281

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 692
    const v3, 0x7f0c0282

    invoke-virtual {p4, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 693
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 694
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 695
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getAvailabilityMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 696
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v1

    if-eqz v1, :cond_39

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/ImageType;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_39

    .line 698
    const v1, 0x7f0c027f

    invoke-virtual {p4, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 699
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/ImageType;->getUrl()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 700
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    :cond_39
    move-object v0, p4

    goto/16 :goto_0

    :cond_3a
    move-object v4, v2

    goto/16 :goto_2

    :cond_3b
    move-object v3, v1

    goto/16 :goto_1
.end method

.method public getChildrenCount(I)I
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 79
    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 80
    iget-object v4, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0802b8

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    move v1, v2

    .line 139
    :cond_0
    :goto_0
    return v1

    .line 82
    :cond_1
    iget-object v4, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0802bf

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v1, v2

    .line 83
    goto :goto_0

    .line 84
    :cond_2
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f0802b9

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 85
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto :goto_0

    .line 86
    :cond_3
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f0802ba

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 87
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getIncludedItems()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto :goto_0

    .line 88
    :cond_4
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f0802be

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 89
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecifications()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto :goto_0

    .line 91
    :cond_5
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f0802bd

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 92
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 94
    :cond_6
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_8

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getCommonFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    :goto_1
    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_9

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getConditionalFeatures()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    :goto_2
    add-int/2addr v0, v2

    iget-object v2, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_7

    iget-object v1, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;->getTerms()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    :cond_7
    add-int/2addr v1, v0

    goto/16 :goto_0

    :cond_8
    move v0, v1

    goto :goto_1

    :cond_9
    move v2, v1

    goto :goto_2

    .line 99
    :cond_a
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f08023b

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 100
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto/16 :goto_0

    .line 103
    :cond_b
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f08018f

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 104
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEpisodesList()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getEpisodesList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto/16 :goto_0

    .line 107
    :cond_c
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f08032e

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 108
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecialFeatures()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecialFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto/16 :goto_0

    .line 111
    :cond_d
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f0800ee

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 112
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    move-result-object v4

    .line 113
    if-eqz v4, :cond_10

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCastMembers()Ljava/util/List;

    move-result-object v0

    move-object v2, v0

    .line 114
    :goto_3
    if-eqz v4, :cond_e

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;->getCrewMembers()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;

    move-result-object v0

    move-object v3, v0

    .line 115
    :cond_e
    if-eqz v4, :cond_0

    .line 116
    if-eqz v2, :cond_11

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    move v2, v0

    :goto_4
    if-eqz v3, :cond_12

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_12

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getWriters()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    :goto_5
    add-int/2addr v2, v0

    if-eqz v3, :cond_13

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_13

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getDirectors()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    :goto_6
    add-int/2addr v0, v2

    if-eqz v3, :cond_f

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_f

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CrewMember;->getOtherCrew()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    :cond_f
    add-int/2addr v1, v0

    .line 120
    goto/16 :goto_0

    :cond_10
    move-object v2, v3

    .line 113
    goto :goto_3

    :cond_11
    move v2, v1

    .line 116
    goto :goto_4

    :cond_12
    move v0, v1

    goto :goto_5

    :cond_13
    move v0, v1

    goto :goto_6

    .line 123
    :cond_14
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080241

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_15

    .line 124
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMusicResponse()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;->getMusicDetails()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto/16 :goto_0

    .line 126
    :cond_15
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08032a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_16

    .line 127
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;->getTracks()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;->getTracks()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto/16 :goto_0

    .line 130
    :cond_16
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080327

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_17

    .line 131
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSoftwareDetails()Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto/16 :goto_0

    .line 133
    :cond_17
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801b3

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_18

    .line 134
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getGameDetails()Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto/16 :goto_0

    .line 136
    :cond_18
    iget-object v2, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801b0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lek;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBonusContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    goto/16 :goto_0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2

    .prologue
    .line 218
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4

    .prologue
    .line 271
    if-nez p3, :cond_0

    .line 272
    new-instance v1, Lel;

    invoke-direct {v1}, Lel;-><init>()V

    .line 273
    iget-object v0, p0, Lek;->d:Landroid/view/LayoutInflater;

    const v2, 0x7f0300a5

    const/4 v3, 0x0

    invoke-virtual {v0, v2, p4, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p3

    .line 274
    const v0, 0x7f0c0258

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lel;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 275
    const v0, 0x7f0c0259

    invoke-virtual {p3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lel;->b:Landroid/widget/ImageView;

    .line 276
    invoke-virtual {p3, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 280
    :goto_0
    iget-object v2, v1, Lel;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, p1}, Lek;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 281
    if-eqz p2, :cond_1

    .line 282
    iget-object v0, v1, Lel;->b:Landroid/widget/ImageView;

    const v1, 0x7f020082

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 287
    :goto_1
    return-object p3

    .line 278
    :cond_0
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lel;

    move-object v1, v0

    goto :goto_0

    .line 284
    :cond_1
    iget-object v0, v1, Lel;->b:Landroid/widget/ImageView;

    const v1, 0x7f0200c7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 228
    const/4 v0, 0x0

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1

    .prologue
    .line 717
    const/4 v0, 0x0

    return v0
.end method

.method public onGroupCollapsed(I)V
    .locals 3

    .prologue
    const v2, 0x7f0b0009

    .line 255
    iget v0, p0, Lek;->g:I

    if-ne v0, p1, :cond_0

    .line 256
    const/4 v0, -0x1

    iput v0, p0, Lek;->g:I

    .line 258
    :cond_0
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 259
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setChildDivider(Landroid/graphics/drawable/Drawable;)V

    .line 260
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setDividerHeight(I)V

    .line 261
    return-void
.end method

.method public onGroupExpanded(I)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const v3, 0x7f0b0009

    .line 233
    iget v0, p0, Lek;->g:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 234
    iput p1, p0, Lek;->g:I

    .line 239
    :goto_0
    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802b9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802ba

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08032e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lek;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801b0

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 243
    :cond_0
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 244
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b004f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setChildDivider(Landroid/graphics/drawable/Drawable;)V

    .line 245
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v4}, Landroid/widget/ExpandableListView;->setDividerHeight(I)V

    .line 251
    :goto_1
    return-void

    .line 236
    :cond_1
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget v1, p0, Lek;->g:I

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->collapseGroup(I)Z

    .line 237
    iput p1, p0, Lek;->g:I

    goto/16 :goto_0

    .line 247
    :cond_2
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 248
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lek;->b:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setChildDivider(Landroid/graphics/drawable/Drawable;)V

    .line 249
    iget-object v0, p0, Lek;->e:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v4}, Landroid/widget/ExpandableListView;->setDividerHeight(I)V

    goto :goto_1
.end method
