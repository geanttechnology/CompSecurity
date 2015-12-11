.class public final enum Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/metadata/AdBreakAsWatched;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

.field public static final enum AD_BREAK_AS_WATCHED_NEVER:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

.field public static final enum AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

.field public static final enum AD_BREAK_AS_WATCHED_ON_END:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;


# instance fields
.field private _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    const-string v1, "AD_BREAK_AS_WATCHED_ON_BEGIN"

    const-string v2, "break_watched_on_begin"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    new-instance v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    const-string v1, "AD_BREAK_AS_WATCHED_ON_END"

    const-string v2, "break_watched_on_end"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_END:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    new-instance v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    const-string v1, "AD_BREAK_AS_WATCHED_NEVER"

    const-string v2, "break_watched_never"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_NEVER:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_END:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_NEVER:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    aput-object v1, v0, v5

    sput-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->$VALUES:[Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->_value:Ljava/lang/String;

    return-void
.end method

.method public static createFrom(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 5

    invoke-static {}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->values()[Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/metadata/AdBreakAsWatched;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->$VALUES:[Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->_value:Ljava/lang/String;

    return-object v0
.end method
