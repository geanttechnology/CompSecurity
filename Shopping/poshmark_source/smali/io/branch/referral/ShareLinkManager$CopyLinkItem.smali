.class Lio/branch/referral/ShareLinkManager$CopyLinkItem;
.super Landroid/content/pm/ResolveInfo;
.source "ShareLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/ShareLinkManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CopyLinkItem"
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/ShareLinkManager;


# direct methods
.method private constructor <init>(Lio/branch/referral/ShareLinkManager;)V
    .locals 0

    .prologue
    .line 368
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager$CopyLinkItem;->this$0:Lio/branch/referral/ShareLinkManager;

    invoke-direct {p0}, Landroid/content/pm/ResolveInfo;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V
    .locals 0
    .param p1, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p2, "x1"    # Lio/branch/referral/ShareLinkManager$1;

    .prologue
    .line 368
    invoke-direct {p0, p1}, Lio/branch/referral/ShareLinkManager$CopyLinkItem;-><init>(Lio/branch/referral/ShareLinkManager;)V

    return-void
.end method


# virtual methods
.method public loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "pm"    # Landroid/content/pm/PackageManager;

    .prologue
    .line 378
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$CopyLinkItem;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;
    invoke-static {v0}, Lio/branch/referral/ShareLinkManager;->access$600(Lio/branch/referral/ShareLinkManager;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/Branch$ShareLinkBuilder;->getCopyUrlIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "pm"    # Landroid/content/pm/PackageManager;

    .prologue
    .line 372
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$CopyLinkItem;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;
    invoke-static {v0}, Lio/branch/referral/ShareLinkManager;->access$600(Lio/branch/referral/ShareLinkManager;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/Branch$ShareLinkBuilder;->getCopyURlText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
