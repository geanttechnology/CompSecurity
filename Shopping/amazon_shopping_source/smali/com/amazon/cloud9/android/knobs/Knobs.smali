.class public Lcom/amazon/cloud9/android/knobs/Knobs;
.super Ljava/lang/Object;
.source "Knobs.java"


# static fields
.field private static final overrides:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/cloud9/android/knobs/Knobs;->overrides:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(TE;TE;)TE;"
        }
    .end annotation

    .prologue
    .line 102
    .local p0, "first":Ljava/lang/Object;, "TE;"
    .local p1, "second":Ljava/lang/Object;, "TE;"
    if-eqz p0, :cond_0

    .end local p0    # "first":Ljava/lang/Object;, "TE;"
    :goto_0
    return-object p0

    .restart local p0    # "first":Ljava/lang/Object;, "TE;"
    :cond_0
    move-object p0, p1

    goto :goto_0
.end method

.method public static get(Ljava/lang/String;I)I
    .locals 1
    .param p0, "knob"    # Ljava/lang/String;
    .param p1, "defaultValue"    # I

    .prologue
    .line 81
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/cloud9/android/knobs/Knobs;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "knob"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 71
    sget-object v0, Lcom/amazon/cloud9/android/knobs/Knobs;->overrides:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {p0, p1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/cloud9/android/knobs/Knobs;->firstNonNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public static get(Ljava/lang/String;Z)Z
    .locals 1
    .param p0, "knob"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Z

    .prologue
    .line 76
    invoke-static {p1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/cloud9/android/knobs/Knobs;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
