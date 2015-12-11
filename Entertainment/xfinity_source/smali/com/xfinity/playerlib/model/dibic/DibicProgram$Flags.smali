.class public final enum Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
.super Ljava/lang/Enum;
.source "DibicProgram.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/dibic/DibicProgram;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Flags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum ADULT:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum HD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum IN_STORE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum IN_THEATER:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum IN_TVLISTING:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum KIDS:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum NEW:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum ON_DVD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum ON_VOD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum PROTECTED:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

.field public static final enum THUMBNAIL:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;


# instance fields
.field public bitMask:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "THUMBNAIL"

    const/high16 v2, -0x80000000

    invoke-direct {v0, v1, v4, v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->THUMBNAIL:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 30
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "PROTECTED"

    const/high16 v2, 0x40000000    # 2.0f

    invoke-direct {v0, v1, v5, v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->PROTECTED:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 31
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "ADULT"

    const/high16 v2, 0x20000000

    invoke-direct {v0, v1, v6, v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ADULT:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 32
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "IN_TVLISTING"

    const/high16 v2, 0x10000000

    invoke-direct {v0, v1, v7, v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_TVLISTING:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 33
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "ON_DVD"

    const/high16 v2, 0x8000000

    invoke-direct {v0, v1, v8, v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ON_DVD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 34
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "IN_THEATER"

    const/4 v2, 0x5

    const/high16 v3, 0x4000000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_THEATER:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 35
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "ON_VOD"

    const/4 v2, 0x6

    const/high16 v3, 0x2000000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ON_VOD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 36
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "IN_STORE"

    const/4 v2, 0x7

    const/high16 v3, 0x1000000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_STORE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 37
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "HD"

    const/16 v2, 0x8

    const/high16 v3, 0x800000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->HD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 38
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "NEW"

    const/16 v2, 0x9

    const/high16 v3, 0x400000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->NEW:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 39
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "DOWNLOADABLE"

    const/16 v2, 0xa

    const/high16 v3, 0x200000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 40
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    const-string v1, "KIDS"

    const/16 v2, 0xb

    const/high16 v3, 0x100000

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->KIDS:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .line 28
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->THUMBNAIL:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->PROTECTED:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ADULT:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_TVLISTING:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v1, v0, v7

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ON_DVD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_THEATER:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ON_VOD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->IN_STORE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->HD:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->NEW:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->KIDS:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->$VALUES:[Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "bitMask"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 45
    iput p3, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->bitMask:I

    .line 46
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 28
    const-class v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->$VALUES:[Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    return-object v0
.end method
