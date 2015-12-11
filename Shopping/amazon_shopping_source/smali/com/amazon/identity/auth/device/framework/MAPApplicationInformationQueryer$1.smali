.class final Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$1;
.super Ljava/lang/Object;
.source "MAPApplicationInformationQueryer.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I
    .locals 1
    .param p1, "info1"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .param p2, "info2"    # Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .prologue
    .line 97
    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->compare(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I

    move-result v0

    mul-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 93
    check-cast p1, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$1;->compare(Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;)I

    move-result v0

    return v0
.end method
