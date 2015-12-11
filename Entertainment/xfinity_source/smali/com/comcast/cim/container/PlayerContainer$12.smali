.class Lcom/comcast/cim/container/PlayerContainer$12;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Landroid/view/LayoutInflater$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 1174
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$12;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 6
    .param p1, "viewName"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v5, 0x0

    .line 1177
    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer$12;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getXfinitySansFamilyName()Ljava/lang/String;

    move-result-object v3

    .line 1178
    .local v3, "xfinitySansFamilyName":Ljava/lang/String;
    const-string v4, "TextView"

    invoke-static {p1, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1179
    new-instance v2, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;

    invoke-direct {v2, p2, p3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 1180
    .local v2, "textView":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;
    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer$12;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getTypefaceManager()Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    move-result-object v4

    invoke-virtual {v2, p2, p3, v5, v4}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->setupDelegate(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V

    .line 1181
    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->setTypefaceFamilyName(Ljava/lang/String;)V

    .line 1194
    .end local v2    # "textView":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;
    :goto_0
    return-object v2

    .line 1183
    :cond_0
    const-string v4, "EditText"

    invoke-static {p1, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1184
    new-instance v1, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;

    invoke-direct {v1, p2, p3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 1185
    .local v1, "editText":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;
    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer$12;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getTypefaceManager()Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    move-result-object v4

    invoke-virtual {v1, p2, p3, v5, v4}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;->setupDelegate(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V

    .line 1186
    invoke-virtual {v1, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;->setTypefaceFamilyName(Ljava/lang/String;)V

    move-object v2, v1

    .line 1187
    goto :goto_0

    .line 1188
    .end local v1    # "editText":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceEditText;
    :cond_1
    const-string v4, "Button"

    invoke-static {p1, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1189
    new-instance v0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;

    invoke-direct {v0, p2, p3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 1190
    .local v0, "button":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;
    iget-object v4, p0, Lcom/comcast/cim/container/PlayerContainer$12;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getTypefaceManager()Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    move-result-object v4

    invoke-virtual {v0, p2, p3, v5, v4}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;->setupDelegate(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V

    .line 1191
    invoke-virtual {v0, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;->setTypefaceFamilyName(Ljava/lang/String;)V

    move-object v2, v0

    .line 1192
    goto :goto_0

    .line 1194
    .end local v0    # "button":Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceButton;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method
