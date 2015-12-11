.class public final enum Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;
.super Ljava/lang/Enum;
.source "FeedItemContentType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/FeedItemContentType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ContentType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum Collection:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum Event:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

.field public static final enum User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "Post"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 10
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "Brand"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 11
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "User"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 12
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "Event"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Event:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 13
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "Collection"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Collection:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 14
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "PoshmarkPost"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 15
    new-instance v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    const-string v1, "Invalid"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    .line 8
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Event:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Collection:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Invalid:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->$VALUES:[Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 8
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 8
    const-class v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->$VALUES:[Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    return-object v0
.end method
