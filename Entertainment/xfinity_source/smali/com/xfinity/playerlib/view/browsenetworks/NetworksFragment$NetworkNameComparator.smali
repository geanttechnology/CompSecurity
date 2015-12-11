.class public Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;
.super Ljava/lang/Object;
.source "NetworksFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NetworkNameComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 395
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Network;)I
    .locals 2
    .param p1, "network1"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p2, "network2"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 398
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 395
    check-cast p1, Lcom/xfinity/playerlib/model/tags/Network;

    check-cast p2, Lcom/xfinity/playerlib/model/tags/Network;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;->compare(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Network;)I

    move-result v0

    return v0
.end method
