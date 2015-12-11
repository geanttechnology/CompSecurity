.class public Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
.super Landroid/app/Fragment;
.source "BrowseFilterCategoryDetailPanel.java"


# static fields
.field public static final ALPHA_FILTER_LABELS:[Ljava/lang/String;

.field protected static final LOG:Lorg/slf4j/Logger;

.field public static final TAG:Ljava/lang/String;


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field adapter:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field protected filterAdapters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ArrayAdapter;",
            ">;"
        }
    .end annotation
.end field

.field private final filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation
.end field

.field protected filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

.field genres:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private inflater:Landroid/view/LayoutInflater;

.field protected isDualPanel:Z

.field protected lastCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field private list:Landroid/widget/ListView;

.field protected talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

.field talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 39
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->LOG:Lorg/slf4j/Logger;

    .line 40
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->TAG:Ljava/lang/String;

    .line 183
    const/16 v0, 0x1a

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "A"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "B"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "C"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "D"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "E"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "F"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "G"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "H"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "I"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "J"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "K"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "L"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "M"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "N"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "O"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "P"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "Q"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "R"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "S"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "T"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "U"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "V"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "W"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "X"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "Y"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "Z"

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->ALPHA_FILTER_LABELS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 89
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 44
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 45
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTalkDelegateFactory()Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterAdapters:Ljava/util/ArrayList;

    .line 53
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->lastCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 60
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 66
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    .line 89
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;)Landroid/view/LayoutInflater;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->inflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method private buildAlphaPairs()[Landroid/util/Pair;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 176
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 177
    .local v0, "pairList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->ALPHA_FILTER_LABELS:[Ljava/lang/String;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v1, v3, v2

    .line 178
    .local v1, "str":Ljava/lang/String;
    new-instance v5, Landroid/util/Pair;

    invoke-direct {v5, v1, v1}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 177
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 180
    .end local v1    # "str":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v2, v2, [Landroid/util/Pair;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/util/Pair;

    return-object v2
.end method

.method private buildGenrePairs()[Landroid/util/Pair;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 160
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 161
    .local v1, "pairList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->genres:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 162
    .local v0, "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    new-instance v3, Landroid/util/Pair;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 165
    .end local v0    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_0
    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$2;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 172
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v2, v2, [Landroid/util/Pair;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/util/Pair;

    return-object v2
.end method

.method private buildNetworkPairs(Ljava/util/List;)[Landroid/util/Pair;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;)[",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 152
    .local p1, "networkList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 153
    .local v1, "pairList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 154
    .local v0, "network":Lcom/xfinity/playerlib/model/tags/Network;
    new-instance v3, Landroid/util/Pair;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 156
    .end local v0    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    new-array v2, v2, [Landroid/util/Pair;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/util/Pair;

    return-object v2
.end method

.method public static newInstance(ZLjava/util/List;)Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    .locals 4
    .param p0, "isDualPanel"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;)",
            "Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 77
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "isDualPanel"

    invoke-virtual {v0, v3, p0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 79
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 80
    .local v2, "genresList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 81
    const-string v3, "genres"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 83
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;-><init>()V

    .line 84
    .local v1, "browseFilterCategoryDetailPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->setArguments(Landroid/os/Bundle;)V

    .line 86
    return-object v1
.end method

.method private turnOnTalkBackForAccessibility()V
    .locals 4

    .prologue
    .line 273
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-nez v0, :cond_0

    .line 275
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    const v3, 0x1020002

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->getTalkDelegate(Landroid/app/Activity;Landroid/view/View;)Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 278
    :cond_0
    return-void
.end method


# virtual methods
.method protected buildCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .param p4, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            "[",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
            ")V"
        }
    .end annotation

    .prologue
    .local p3, "idLabelPairs":[Landroid/util/Pair;, "[Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v3, 0x0

    .line 190
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;

    move-object v1, p0

    move-object v2, p1

    move-object v4, p3

    move-object v5, p2

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;Landroid/content/Context;I[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    .line 209
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterAdapters:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 211
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    if-eqz v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    invoke-virtual {v0, v3}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    invoke-virtual {p0, v0, p4}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->setFilterListOnItemClickListener(Landroid/widget/ListView;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 217
    :cond_0
    iput-object p4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->lastCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 218
    return-void
.end method

.method public changeCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "filter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .param p3, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .param p4, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .prologue
    .line 125
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->genres:Ljava/util/List;

    if-nez v1, :cond_0

    .line 126
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "genres"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->genres:Ljava/util/List;

    .line 129
    :cond_0
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$5;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory:[I

    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 143
    :cond_1
    :goto_0
    return-void

    .line 131
    :pswitch_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildGenrePairs()[Landroid/util/Pair;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, p1, p2, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    goto :goto_0

    .line 134
    :pswitch_1
    invoke-interface {p4}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v0

    .line 135
    .local v0, "networkList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_1

    .line 136
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildNetworkPairs(Ljava/util/List;)[Landroid/util/Pair;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, p1, p2, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    goto :goto_0

    .line 140
    .end local v0    # "networkList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    :pswitch_2
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildAlphaPairs()[Landroid/util/Pair;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, p1, p2, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    goto :goto_0

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterChangeListener:Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    return-object v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 93
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 94
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    .line 95
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 99
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 100
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 101
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 102
    const-string v1, "isDualPanel"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->isDualPanel:Z

    .line 103
    const-string v1, "genres"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->genres:Ljava/util/List;

    .line 105
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 109
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->inflater:Landroid/view/LayoutInflater;

    .line 110
    sget v1, Lcom/xfinity/playerlib/R$layout;->filter_dialog_category:I

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 112
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->list:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    .line 115
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 117
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->lastCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->setFilterListOnItemClickListener(Landroid/widget/ListView;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 118
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->list:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 121
    :cond_0
    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 265
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->onDestroy()V

    .line 268
    :cond_0
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 269
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 147
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 148
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->turnOnTalkBackForAccessibility()V

    .line 149
    return-void
.end method

.method protected setFilterListOnItemClickListener(Landroid/widget/ListView;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 1
    .param p1, "list"    # Landroid/widget/ListView;
    .param p2, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 222
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;

    invoke-direct {v0, p0, p2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    invoke-virtual {p1, v0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 240
    return-void
.end method

.method protected speak(I)V
    .locals 1
    .param p1, "sayWhatResId"    # I

    .prologue
    .line 250
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 251
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->speak(Ljava/lang/String;)V

    .line 253
    :cond_0
    return-void
.end method

.method protected speak(Ljava/lang/String;)V
    .locals 1
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 257
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 260
    :cond_0
    return-void
.end method
