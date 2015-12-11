.class public final enum Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
.super Ljava/lang/Enum;
.source "SpeechPresentationMode.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field public static final enum OPEN:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field public static final enum PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field public static final enum SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    const-string v1, "SEARCH"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .line 5
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    const-string v1, "OPEN"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .line 6
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    const-string v1, "PLAY"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .line 3
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->$VALUES:[Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

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

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->$VALUES:[Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {v0}, [Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    return-object v0
.end method
