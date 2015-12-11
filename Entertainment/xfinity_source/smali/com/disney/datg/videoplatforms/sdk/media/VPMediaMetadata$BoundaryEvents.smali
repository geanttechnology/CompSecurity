.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;
.super Ljava/lang/Enum;
.source "VPMediaMetadata.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BoundaryEvents"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum AD_BREAK_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum AD_BREAK_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum AD_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum AD_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum PROGRAM_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

.field public static final enum PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 13
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "AD_START"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "AD_END"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "AD_BREAK_START"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_BREAK_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "AD_BREAK_END"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_BREAK_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "PROGRAM_START"

    invoke-direct {v0, v1, v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const-string v1, "PROGRAM_END"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->PROGRAM_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    const/4 v0, 0x6

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_BREAK_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->AD_BREAK_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->PROGRAM_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    aput-object v2, v0, v1

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata$BoundaryEvents;

    return-object v0
.end method
