.class Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;
.super Ljava/lang/Object;
.source "DefaultDibicResource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProcessedItems"
.end annotation


# instance fields
.field adultGenres:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field adultMerlinIdMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field adultNetworkGenreMaps:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;>;"
        }
    .end annotation
.end field

.field merlinIdMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field networkGenreMaps:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;>;"
        }
    .end annotation
.end field

.field nonAdultPrograms:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;)V
    .locals 0

    .prologue
    .line 265
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->this$0:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;
    .param p2, "x1"    # Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$1;

    .prologue
    .line 265
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;-><init>(Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;)V

    return-void
.end method
