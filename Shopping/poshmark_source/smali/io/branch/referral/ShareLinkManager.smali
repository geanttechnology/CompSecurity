.class Lio/branch/referral/ShareLinkManager;
.super Ljava/lang/Object;
.source "ShareLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/referral/ShareLinkManager$CopyLinkItem;,
        Lio/branch/referral/ShareLinkManager$MoreShareItem;,
        Lio/branch/referral/ShareLinkManager$ShareItemView;,
        Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;
    }
.end annotation


# static fields
.field private static viewItemMinHeight_:I


# instance fields
.field private final BG_COLOR_DISABLED:I

.field private final BG_COLOR_ENABLED:I

.field private appList_:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation
.end field

.field private builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

.field callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

.field context_:Landroid/content/Context;

.field private isShareInProgress_:Z

.field shareDlg_:Lio/branch/referral/AnimatedDialog;

.field private shareLinkIntent_:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const/16 v0, 0x64

    sput v0, Lio/branch/referral/ShareLinkManager;->viewItemMinHeight_:I

    return-void
.end method

.method constructor <init>()V
    .locals 4

    .prologue
    const/16 v3, 0x38

    const/16 v2, 0x11

    const/4 v1, 0x4

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/16 v0, 0x3c

    invoke-static {v0, v2, v1, v3}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    iput v0, p0, Lio/branch/referral/ShareLinkManager;->BG_COLOR_ENABLED:I

    .line 40
    const/16 v0, 0x14

    invoke-static {v0, v2, v1, v3}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    iput v0, p0, Lio/branch/referral/ShareLinkManager;->BG_COLOR_DISABLED:I

    .line 46
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z

    .line 368
    return-void
.end method

.method static synthetic access$1000(Lio/branch/referral/ShareLinkManager;)I
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;

    .prologue
    .line 29
    iget v0, p0, Lio/branch/referral/ShareLinkManager;->BG_COLOR_DISABLED:I

    return v0
.end method

.method static synthetic access$300(Lio/branch/referral/ShareLinkManager;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;

    .prologue
    .line 29
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$302(Lio/branch/referral/ShareLinkManager;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 29
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$400(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p1, "x1"    # Landroid/content/pm/ResolveInfo;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lio/branch/referral/ShareLinkManager;->invokeSharingClient(Landroid/content/pm/ResolveInfo;)V

    return-void
.end method

.method static synthetic access$500(Lio/branch/referral/ShareLinkManager;)Z
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;

    .prologue
    .line 29
    iget-boolean v0, p0, Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z

    return v0
.end method

.method static synthetic access$502(Lio/branch/referral/ShareLinkManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p1, "x1"    # Z

    .prologue
    .line 29
    iput-boolean p1, p0, Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z

    return p1
.end method

.method static synthetic access$600(Lio/branch/referral/ShareLinkManager;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;

    .prologue
    .line 29
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    return-object v0
.end method

.method static synthetic access$602(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/Branch$ShareLinkBuilder;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p1, "x1"    # Lio/branch/referral/Branch$ShareLinkBuilder;

    .prologue
    .line 29
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    return-object p1
.end method

.method static synthetic access$700(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p1, "x1"    # Landroid/content/pm/ResolveInfo;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ShareLinkManager;->shareWithClient(Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$800()I
    .locals 1

    .prologue
    .line 29
    sget v0, Lio/branch/referral/ShareLinkManager;->viewItemMinHeight_:I

    return v0
.end method

.method static synthetic access$802(I)I
    .locals 0
    .param p0, "x0"    # I

    .prologue
    .line 29
    sput p0, Lio/branch/referral/ShareLinkManager;->viewItemMinHeight_:I

    return p0
.end method

.method static synthetic access$900(Lio/branch/referral/ShareLinkManager;)I
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ShareLinkManager;

    .prologue
    .line 29
    iget v0, p0, Lio/branch/referral/ShareLinkManager;->BG_COLOR_ENABLED:I

    return v0
.end method

.method private addLinkToClipBoard(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 256
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 257
    .local v2, "sdk":I
    const/16 v3, 0xb

    if-ge v2, v3, :cond_0

    .line 258
    iget-object v3, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    const-string v4, "clipboard"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/text/ClipboardManager;

    .line 259
    .local v1, "clipboard":Landroid/text/ClipboardManager;
    invoke-virtual {v1, p1}, Landroid/text/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 265
    .end local v1    # "clipboard":Landroid/text/ClipboardManager;
    :goto_0
    iget-object v3, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    iget-object v4, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-virtual {v4}, Lio/branch/referral/Branch$ShareLinkBuilder;->getUrlCopiedMessage()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 266
    return-void

    .line 261
    :cond_0
    iget-object v3, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    const-string v4, "clipboard"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ClipboardManager;

    .line 262
    .local v1, "clipboard":Landroid/content/ClipboardManager;
    invoke-static {p2, p1}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 263
    .local v0, "clip":Landroid/content/ClipData;
    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    goto :goto_0
.end method

.method private createShareDialog(Ljava/util/List;)V
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 105
    .local p1, "preferredOptions":Ljava/util/List;, "Ljava/util/List<Lio/branch/referral/SharingHelper$SHARE_WITH;>;"
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 106
    .local v6, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 107
    .local v9, "preferredApps":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    const/high16 v13, 0x10000

    invoke-virtual {v6, v12, v13}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v5

    .line 108
    .local v5, "matchingApps":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 111
    .local v8, "packagesFilterList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lio/branch/referral/SharingHelper$SHARE_WITH;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/pm/ResolveInfo;

    .line 112
    .local v10, "resolveInfo":Landroid/content/pm/ResolveInfo;
    const/4 v2, 0x0

    .line 113
    .local v2, "foundMatching":Lio/branch/referral/SharingHelper$SHARE_WITH;
    iget-object v12, v10, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v7, v12, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    .line 114
    .local v7, "packageName":Ljava/lang/String;
    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/branch/referral/SharingHelper$SHARE_WITH;

    .line 115
    .local v0, "PackageFilter":Lio/branch/referral/SharingHelper$SHARE_WITH;
    iget-object v12, v10, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v12, :cond_1

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0}, Lio/branch/referral/SharingHelper$SHARE_WITH;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 116
    move-object v2, v0

    .line 120
    .end local v0    # "PackageFilter":Lio/branch/referral/SharingHelper$SHARE_WITH;
    :cond_2
    if-eqz v2, :cond_0

    .line 121
    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 122
    invoke-interface {p1, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 126
    .end local v2    # "foundMatching":Lio/branch/referral/SharingHelper$SHARE_WITH;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v7    # "packageName":Ljava/lang/String;
    .end local v10    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    :cond_3
    invoke-interface {v5, v9}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 127
    const/4 v12, 0x0

    invoke-interface {v5, v12, v9}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    .line 129
    new-instance v12, Lio/branch/referral/ShareLinkManager$CopyLinkItem;

    const/4 v13, 0x0

    invoke-direct {v12, p0, v13}, Lio/branch/referral/ShareLinkManager$CopyLinkItem;-><init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V

    invoke-interface {v5, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 130
    new-instance v12, Lio/branch/referral/ShareLinkManager$CopyLinkItem;

    const/4 v13, 0x0

    invoke-direct {v12, p0, v13}, Lio/branch/referral/ShareLinkManager$CopyLinkItem;-><init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V

    invoke-interface {v9, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 132
    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v12

    const/4 v13, 0x1

    if-le v12, v13, :cond_6

    .line 134
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v12

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v13

    if-le v12, v13, :cond_4

    .line 135
    new-instance v12, Lio/branch/referral/ShareLinkManager$MoreShareItem;

    const/4 v13, 0x0

    invoke-direct {v12, p0, v13}, Lio/branch/referral/ShareLinkManager$MoreShareItem;-><init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V

    invoke-interface {v9, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    :cond_4
    iput-object v9, p0, Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;

    .line 144
    :goto_1
    new-instance v1, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;

    const/4 v12, 0x0

    invoke-direct {v1, p0, v12}, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;-><init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V

    .line 145
    .local v1, "adapter":Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;
    new-instance v11, Landroid/widget/ListView;

    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-direct {v11, v12}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 146
    .local v11, "shareOptionListView":Landroid/widget/ListView;
    invoke-virtual {v11, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 147
    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setHorizontalFadingEdgeEnabled(Z)V

    .line 148
    const/4 v12, -0x1

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setBackgroundColor(I)V

    .line 150
    new-instance v12, Lio/branch/referral/ShareLinkManager$1;

    invoke-direct {v12, p0, v5, v1}, Lio/branch/referral/ShareLinkManager$1;-><init>(Lio/branch/referral/ShareLinkManager;Ljava/util/List;Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;)V

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 170
    new-instance v12, Lio/branch/referral/AnimatedDialog;

    iget-object v13, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-direct {v12, v13}, Lio/branch/referral/AnimatedDialog;-><init>(Landroid/content/Context;)V

    iput-object v12, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    .line 171
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v12, v11}, Lio/branch/referral/AnimatedDialog;->setContentView(Landroid/view/View;)V

    .line 172
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v12}, Lio/branch/referral/AnimatedDialog;->show()V

    .line 173
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v12, :cond_5

    .line 174
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    invoke-interface {v12}, Lio/branch/referral/Branch$BranchLinkShareListener;->onShareLinkDialogLaunched()V

    .line 176
    :cond_5
    iget-object v12, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    new-instance v13, Lio/branch/referral/ShareLinkManager$2;

    invoke-direct {v13, p0}, Lio/branch/referral/ShareLinkManager$2;-><init>(Lio/branch/referral/ShareLinkManager;)V

    invoke-virtual {v12, v13}, Lio/branch/referral/AnimatedDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 191
    return-void

    .line 139
    .end local v1    # "adapter":Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;
    .end local v11    # "shareOptionListView":Landroid/widget/ListView;
    :cond_6
    iput-object v5, p0, Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;

    goto :goto_1
.end method

.method private invokeSharingClient(Landroid/content/pm/ResolveInfo;)V
    .locals 3
    .param p1, "selectedResolveInfo"    # Landroid/content/pm/ResolveInfo;

    .prologue
    .line 200
    const/4 v2, 0x1

    iput-boolean v2, p0, Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z

    .line 201
    iget-object v2, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 202
    .local v0, "channelName":Ljava/lang/String;
    iget-object v2, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-virtual {v2}, Lio/branch/referral/Branch$ShareLinkBuilder;->getShortLinkBuilder()Lio/branch/referral/BranchShortLinkBuilder;

    move-result-object v1

    .line 203
    .local v1, "shortLinkBuilder":Lio/branch/referral/BranchShortLinkBuilder;
    invoke-virtual {v1, v0}, Lio/branch/referral/BranchShortLinkBuilder;->setChannel(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 205
    new-instance v2, Lio/branch/referral/ShareLinkManager$3;

    invoke-direct {v2, p0, p1, v0}, Lio/branch/referral/ShareLinkManager$3;-><init>(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lio/branch/referral/BranchShortLinkBuilder;->generateShortUrl(Lio/branch/referral/Branch$BranchLinkCreateListener;)V

    .line 226
    return-void
.end method

.method private shareWithClient(Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "selectedResolveInfo"    # Landroid/content/pm/ResolveInfo;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "channelName"    # Ljava/lang/String;

    .prologue
    .line 229
    instance-of v1, p1, Lio/branch/referral/ShareLinkManager$CopyLinkItem;

    if-eqz v1, :cond_0

    .line 230
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-virtual {v1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getShareMsg()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p2, v1}, Lio/branch/referral/ShareLinkManager;->addLinkToClipBoard(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    :goto_0
    return-void

    .line 232
    :cond_0
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v1, :cond_2

    .line 233
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    const/4 v2, 0x0

    invoke-interface {v1, p2, p3, v2}, Lio/branch/referral/Branch$BranchLinkShareListener;->onLinkShareResponse(Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 237
    :goto_1
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    iget-object v2, p1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 238
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-virtual {v1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getShareSub()Ljava/lang/String;

    move-result-object v0

    .line 239
    .local v0, "shareSub":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 240
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    const-string v2, "android.intent.extra.SUBJECT"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 242
    :cond_1
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    const-string v2, "android.intent.extra.TEXT"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-virtual {v4}, Lio/branch/referral/Branch$ShareLinkBuilder;->getShareMsg()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 243
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    iget-object v2, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    invoke-virtual {v1, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 235
    .end local v0    # "shareSub":Ljava/lang/String;
    :cond_2
    const-string v1, "BranchSDK"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Shared link with "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method


# virtual methods
.method public cancelShareLinkDialog(Z)V
    .locals 1
    .param p1, "animateClose"    # Z

    .prologue
    .line 86
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v0}, Lio/branch/referral/AnimatedDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    if-eqz p1, :cond_1

    .line 89
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v0}, Lio/branch/referral/AnimatedDialog;->cancel()V

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    invoke-virtual {v0}, Lio/branch/referral/AnimatedDialog;->dismiss()V

    goto :goto_0
.end method

.method public shareLink(Lio/branch/referral/Branch$ShareLinkBuilder;)Landroid/app/Dialog;
    .locals 6
    .param p1, "builder"    # Lio/branch/referral/Branch$ShareLinkBuilder;

    .prologue
    const/4 v5, 0x0

    .line 58
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 59
    invoke-virtual {p1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iput-object v1, p0, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    .line 60
    invoke-virtual {p1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getCallback()Lio/branch/referral/Branch$BranchLinkShareListener;

    move-result-object v1

    iput-object v1, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    .line 61
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    .line 62
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareLinkIntent_:Landroid/content/Intent;

    const-string v2, "text/plain"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 65
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getPreferredOptions()Ljava/util/ArrayList;

    move-result-object v1

    invoke-direct {p0, v1}, Lio/branch/referral/ShareLinkManager;->createShareDialog(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    :goto_0
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->shareDlg_:Lio/branch/referral/AnimatedDialog;

    return-object v1

    .line 66
    :catch_0
    move-exception v0

    .line 67
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 68
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Trouble sharing link"

    const/16 v4, -0x6e

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v5, v5, v2}, Lio/branch/referral/Branch$BranchLinkShareListener;->onLinkShareResponse(Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/BranchError;)V

    goto :goto_0

    .line 71
    :cond_0
    const-string v1, "BranchSDK"

    const-string v2, "Unable create share options. Couldn\'t find applications on device to share the link."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
