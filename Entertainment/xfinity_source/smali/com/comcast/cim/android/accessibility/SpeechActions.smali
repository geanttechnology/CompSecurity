.class public final enum Lcom/comcast/cim/android/accessibility/SpeechActions;
.super Ljava/lang/Enum;
.source "SpeechActions.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/android/accessibility/SpeechActions;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum CANCEL:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum CLEAR:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum CLOSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum FEEDBACK:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum HELP:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum JUST_A_NUMBER:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum JUST_SOME_WORDS:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum LESS:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum MORE:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum PAUSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum READ_MODE:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum REPEAT:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum REWIND:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum SEEK:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum UNDO:Lcom/comcast/cim/android/accessibility/SpeechActions;

.field public static final enum UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "UNRECOGNIZED"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 5
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "LESS"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->LESS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 6
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "MORE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->MORE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 7
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "REPEAT"

    invoke-direct {v0, v1, v6}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->REPEAT:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 8
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "CLEAR"

    invoke-direct {v0, v1, v7}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLEAR:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 9
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "CLOSE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLOSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 10
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "SEARCH"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 11
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "OPEN"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 12
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "REWIND"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->REWIND:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 13
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "PLAY"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 14
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "PAUSE"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->PAUSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 15
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "SEEK"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEEK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 16
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "UNDO"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNDO:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 17
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "CANCEL"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CANCEL:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 18
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "HELP"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->HELP:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 19
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "READ_MODE"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->READ_MODE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 20
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "JUST_A_NUMBER"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->JUST_A_NUMBER:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 21
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "JUST_SOME_WORDS"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->JUST_SOME_WORDS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 22
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "FEEDBACK"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->FEEDBACK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 23
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    const-string v1, "IGNORE_REENTRY"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechActions;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 3
    const/16 v0, 0x14

    new-array v0, v0, [Lcom/comcast/cim/android/accessibility/SpeechActions;

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->LESS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->MORE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->REPEAT:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLEAR:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLOSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->REWIND:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->PAUSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEEK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNDO:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->CANCEL:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->HELP:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->READ_MODE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->JUST_A_NUMBER:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->JUST_SOME_WORDS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->FEEDBACK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->$VALUES:[Lcom/comcast/cim/android/accessibility/SpeechActions;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/accessibility/SpeechActions;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/SpeechActions;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/android/accessibility/SpeechActions;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->$VALUES:[Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {v0}, [Lcom/comcast/cim/android/accessibility/SpeechActions;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/android/accessibility/SpeechActions;

    return-object v0
.end method
